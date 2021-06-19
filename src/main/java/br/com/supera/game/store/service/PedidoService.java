package br.com.supera.game.store.service;


import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PedidoService {

    public BigDecimal calcularFrete(Integer quantidadeItens){
        BigDecimal frete = BigDecimal.TEN;
        frete = frete.multiply(new BigDecimal(quantidadeItens));
        if (frete.compareTo(new BigDecimal(250)) == 1){
            frete = BigDecimal.ZERO;
        }
        return  frete;
    }
}
