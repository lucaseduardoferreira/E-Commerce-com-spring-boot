package br.com.supera.game.store.controller;


import br.com.supera.game.store.model.Cliente;
import br.com.supera.game.store.model.Pedido;
import br.com.supera.game.store.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadatrar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
