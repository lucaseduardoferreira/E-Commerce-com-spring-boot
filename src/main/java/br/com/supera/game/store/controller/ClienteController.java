package br.com.supera.game.store.controller;


import br.com.supera.game.store.model.Cliente;
import br.com.supera.game.store.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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

    @GetMapping
    public Page<Cliente> lista(@PageableDefault(sort = "nome", direction = Sort.Direction.ASC) Pageable paginacao) {

        return clienteRepository.findAll(paginacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            cliente = clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        }

        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> detalhar(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }
}
