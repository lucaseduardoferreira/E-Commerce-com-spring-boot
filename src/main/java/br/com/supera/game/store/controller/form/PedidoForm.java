package br.com.supera.game.store.controller.form;

import br.com.supera.game.store.exception.IDInvalidoException;
import br.com.supera.game.store.model.Cliente;
import br.com.supera.game.store.model.Pedido;
import br.com.supera.game.store.repository.ClienteRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoForm {


    private Long idCliente;

    private BigDecimal total;

    private List<ItemPedidoForm> itens = new ArrayList<>();

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setItens(List<ItemPedidoForm> itens) {
        this.itens = itens;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<ItemPedidoForm> getItens() {
        return itens;
    }

    public Pedido converter(ClienteRepository clienteRepository){

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() ->new IDInvalidoException("Cliente não cadastrado")
                );

        return new Pedido(cliente, LocalDate.now(), total);

    }
}
