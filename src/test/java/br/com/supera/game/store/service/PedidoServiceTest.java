package br.com.supera.game.store.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {

    @Test
    void deveriaRetornarZeroParaQuantidadeItensMaiorQue26() {
        PedidoService pedidoService = new PedidoService();
        BigDecimal frete = pedidoService.calcularFrete(26);
        assertEquals(frete, BigDecimal.ZERO);
    }
}