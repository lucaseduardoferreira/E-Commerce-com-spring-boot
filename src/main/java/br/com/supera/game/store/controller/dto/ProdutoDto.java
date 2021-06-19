package br.com.supera.game.store.controller.dto;

import br.com.supera.game.store.model.ItemPedido;
import br.com.supera.game.store.model.Produto;

import java.math.BigDecimal;

public class ProdutoDto {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidade;

    public ProdutoDto(ItemPedido itemPedido) {
        this.id = itemPedido.getProduto().getId();
        this.nome = itemPedido.getProduto().getNome();
        this.preco = itemPedido.getProduto().getPreco();
        this.quantidade = itemPedido.getQuantidade();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
