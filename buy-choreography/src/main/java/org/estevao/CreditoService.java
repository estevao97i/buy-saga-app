package org.estevao;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class CreditoService {

    public int creditoTotal = 100;
    public Map<Long, Double> pedido_valor = new HashMap<>();

    public void newPedidoValor(Long id, Double valor) {
        if (valor > creditoTotal) {
            throw new IllegalStateException("Valor acima do esperado");
        }
        creditoTotal -= valor;
        pedido_valor.put(id, valor);
    }

    public void removePedidoValor(Long id) {
        creditoTotal += pedido_valor.get(id);
        pedido_valor.remove(id);
    }

}
