package br.com.supera.game.store.controller.dto;

import br.com.supera.game.store.model.Pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesPedidoDto {
    private Long id;
    private String cliente;
    private BigDecimal total;
    private LocalDate dataPedido;
    private List<ProdutoDto> produtos;

    public DetalhesPedidoDto(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = pedido.getCliente().getNome();
        this.total = pedido.getTotal();
        this.dataPedido = pedido.getDataPedido();
        this.produtos = new ArrayList<>();
        this.produtos.addAll(pedido.getItens().stream().map(ProdutoDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }
}
