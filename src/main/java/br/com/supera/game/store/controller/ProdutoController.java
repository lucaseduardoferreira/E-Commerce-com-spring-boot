package br.com.supera.game.store.controller;


import br.com.supera.game.store.model.Produto;
import br.com.supera.game.store.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

   /* @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> lista(){
        return produtoRepository.findAll();
    }*/

    @GetMapping
    public Page<Produto> lista(@RequestParam(required = false) String nomeCurso,
                               @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable paginacao) {

        return produtoRepository.findAll(paginacao);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadatrar(@RequestBody @Valid Produto produto){
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            produto = produtoRepository.save(optional.get());
            return ResponseEntity.ok(produto);
        }

        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }



}
