package br.com.supera.game.store.controller;


import br.com.supera.game.store.model.Pedido;
import br.com.supera.game.store.model.dto.PedidoDto;
import br.com.supera.game.store.repository.ClienteRepository;
import br.com.supera.game.store.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido cadatrar(@RequestBody PedidoDto pedidoDto){
        Pedido pedido = pedidoDto.converter(clienteRepository);
       return pedidoRepository.save(pedido);
    }


}
