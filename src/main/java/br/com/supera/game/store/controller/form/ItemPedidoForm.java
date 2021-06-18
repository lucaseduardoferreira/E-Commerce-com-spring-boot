package br.com.supera.game.store.controller.form;

import br.com.supera.game.store.model.ItemPedido;
import br.com.supera.game.store.model.Pedido;
import br.com.supera.game.store.model.Produto;
import br.com.supera.game.store.repository.ProdutoRepository;

import java.util.Optional;

public class ItemPedidoForm {

    private Long produto;
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
        Optional<Produto> produto = produtoRepository.findById(this.produto);
        return new ItemPedido(pedido, produto.get(), quantidade);
    }
}
