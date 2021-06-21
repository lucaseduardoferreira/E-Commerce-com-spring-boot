package br.com.supera.game.store.service;


import br.com.supera.game.store.model.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PedidoService {

    public BigDecimal calcularFrete2(Integer quantidadeItens){
        BigDecimal frete = BigDecimal.TEN;
        frete = frete.multiply(new BigDecimal(quantidadeItens));
        if (frete.compareTo(new BigDecimal(250)) == 1){
            frete = BigDecimal.ZERO;
        }
        return  frete;
    }

    public BigDecimal calcularFrete(Pedido pedido) {
        BigDecimal frete = BigDecimal.TEN;
        BigDecimal quantidadeItens = new BigDecimal(pedido.getQuantidadeTotalItens());
        System.out.println(" quantidade de itens"+quantidadeItens);
        frete = frete.multiply(quantidadeItens);

        if (pedido.getvalorTotaProdutos().compareTo(new BigDecimal(250)) >= 0) {

            frete = BigDecimal.ZERO;
        }
        return frete;
    }

}
