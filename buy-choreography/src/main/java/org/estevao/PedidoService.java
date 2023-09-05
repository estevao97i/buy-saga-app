package org.estevao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class PedidoService {

    @Inject
    CreditoService creditoService;

    public Set<Long> id = new HashSet<>();

    public void newPedido(Long id, Double valor) {
        this.id.add(id);
        try {
            creditoService.newPedidoValor(id, valor);
            System.out.println("Pedido " + id + " registrado no valor de: " + valor);
        } catch (IllegalStateException e) {
            removePedido(id);
            System.err.println("Pedido " + id + " estornado no valor de: " + valor);
            System.out.println();
        }
    }

    public void removePedido(Long id) {
        this.id.remove(id);
    }

}
