package br.com.supera.game.store.model.dto;

import br.com.supera.game.store.model.Cliente;
import br.com.supera.game.store.model.Pedido;
import br.com.supera.game.store.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class PedidoDto {

    private Long idCliente;

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Pedido converter(ClienteRepository clienteRepository){

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        return new Pedido(cliente.get());

    }
}
