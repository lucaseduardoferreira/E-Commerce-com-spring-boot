package br.com.supera.game.store.controller;


import br.com.supera.game.store.controller.dto.DetalhesPedidoDto;
import br.com.supera.game.store.controller.dto.PedidoDto;
import br.com.supera.game.store.controller.form.ItemPedidoForm;
import br.com.supera.game.store.model.ItemPedido;
import br.com.supera.game.store.model.Pedido;
import br.com.supera.game.store.controller.form.PedidoForm;
import br.com.supera.game.store.repository.ClienteRepository;
import br.com.supera.game.store.repository.ItemPedidoRepository;
import br.com.supera.game.store.repository.PedidoRepository;
import br.com.supera.game.store.repository.ProdutoRepository;
import br.com.supera.game.store.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoService pedidoService;




    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido cadatrar(@RequestBody PedidoForm pedidoForm){
        Pedido pedido = pedidoForm.converter(clienteRepository);
        pedidoRepository.save(pedido);

        List<ItemPedido> itensPedido = new ArrayList<>();
        List<ItemPedidoForm> itensPedidoForm = pedidoForm.getItens();


        for(ItemPedidoForm itemPedidoForm : itensPedidoForm) {
            itensPedido.add(itemPedidoForm.converter(pedido, produtoRepository));
        }

        pedido.setItens(itensPedido);
        pedido.setFrete(pedidoService.calcularFrete(pedido.getQuantidadeTotal()));
        pedido.setTotal(pedido.getTotal());


        itemPedidoRepository.saveAll(itensPedido);
       return pedido;
    }

    @GetMapping
    public List<PedidoDto> lista() {
            List<Pedido> pedidos = pedidoRepository.findAll();
            return PedidoDto.converter(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesPedidoDto> detalhar(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(new DetalhesPedidoDto(pedido.get()));
        }

        return ResponseEntity.notFound().build();
    }


}
