package br.com.supera.game.store.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private LocalDate dataPedido;
    private BigDecimal valorTotaProdutos;
    private BigDecimal frete;
    private BigDecimal valorTotalPedido;


    @JsonIgnore
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente, LocalDate dataPedido, BigDecimal valorTotaProdutos) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.valorTotaProdutos = valorTotaProdutos;
    }

    public BigDecimal getvalorTotaProdutos(){
        BigDecimal valorTotalProdutos = BigDecimal.ZERO;
        for (ItemPedido itemPedido : itens) {
            valorTotalProdutos = valorTotalProdutos.add(itemPedido.getSubTotal());
        }
        return valorTotalProdutos;
    }

    public Integer getQuantidadeTotalItens(){
        Integer quantidade = 0;
        for (ItemPedido itemPedido : itens) {
            quantidade += itemPedido.getQuantidade();
        }
        return quantidade;

    }





}
