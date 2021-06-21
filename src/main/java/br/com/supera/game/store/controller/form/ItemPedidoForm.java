package br.com.supera.game.store.controller.form;

import br.com.supera.game.store.exception.IDInvalidoException;
import br.com.supera.game.store.model.ItemPedido;
import br.com.supera.game.store.model.Pedido;
import br.com.supera.game.store.model.Produto;
import br.com.supera.game.store.repository.ProdutoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ItemPedidoForm {

    @NotNull @NotEmpty
    private Long produto;

    @NotNull @NotEmpty
    private Integer quantidade;

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ItemPedido converter(Pedido pedido, ProdutoRepository produtoRepository){
        Produto produto = produtoRepository.findById(this.produto).orElseThrow(
                ()-> new IDInvalidoException("Produto não cadastrado")
        );
        return new ItemPedido(pedido, produto, quantidade);
    }
}
