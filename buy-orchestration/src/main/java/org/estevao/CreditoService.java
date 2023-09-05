package org.estevao;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped // serve para injetar essa classe em outra
public class CreditoService {

    private int creditoTotal;
    private Map<Long, Integer> pedido_valor = new HashMap<>();

    public CreditoService() {
        this.creditoTotal = 100;
    }

    public void newPedidoValor(Long pedidoId, int valor) {
        if (valor > creditoTotal) {
            throw new IllegalStateException("Saldo insuficiente");
        }

        creditoTotal = creditoTotal - valor;
        pedido_valor.put(pedidoId, valor);
    }

    public void cancelPedidoValor(Long pedidoId) {
        creditoTotal = creditoTotal + pedido_valor.get(pedidoId); // aqui recupera o valor pela chave
        pedido_valor.remove(pedidoId);
    }
}
