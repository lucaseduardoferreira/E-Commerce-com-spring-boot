package br.com.supera.game.store.service;

import br.com.supera.game.store.model.Cliente;
import br.com.supera.game.store.model.ItemPedido;
import br.com.supera.game.store.model.Pedido;
import br.com.supera.game.store.model.Produto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {

    @Test
    void deveriaRetornarZeroParaValorMaiorQue250() {
        PedidoService pedidoService = new PedidoService();

        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Teste de Cliente");

        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Teste de  Produto");
        produto.setPreco(new BigDecimal(252));
        produto.setImagem("Teste.jpg");
        produto.setScore((short) 5);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDate.now());

        ItemPedido itemPedido = new ItemPedido(pedido, produto, 1);

        List<ItemPedido> itens = new ArrayList<>();
        itens.add(itemPedido);
        pedido.setItens(itens);

        BigDecimal frete = pedidoService.calcularFrete(pedido);
        assertEquals(frete, BigDecimal.ZERO);
    }
}