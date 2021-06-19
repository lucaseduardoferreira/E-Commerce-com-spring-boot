package br.com.supera.game.store.controller.form;

import br.com.supera.game.store.model.Cliente;
import br.com.supera.game.store.model.ItemPedido;
import br.com.supera.game.store.model.Pedido;
import br.com.supera.game.store.repository.ClienteRepository;
import br.com.supera.game.store.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);


        return new Pedido(cliente.get(), LocalDate.now(), total);

    }
}
