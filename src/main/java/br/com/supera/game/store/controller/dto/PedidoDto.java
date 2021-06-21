package br.com.supera.game.store.controller.dto;

import br.com.supera.game.store.model.Pedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoDto {
    private Long id;
    private String cliente;
    private BigDecimal valorTotalPedido;
    private LocalDate dataPedido;

    public PedidoDto(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = pedido.getCliente().getNome();
        this.valorTotalPedido = pedido.getValorTotalPedido();
        this.dataPedido = pedido.getDataPedido();
    }

    public Long getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public BigDecimal getValorTotalPedido() {
        return valorTotalPedido;
    }

    public static List<PedidoDto> converter(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoDto::new).collect(Collectors.toList());
    }
}
