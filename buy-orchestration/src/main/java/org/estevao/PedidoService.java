package org.estevao;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped // serve para injeção dessa classe em outra
public class PedidoService {

    private Set<Long> pedidos = new HashSet<>();

    public void newPedido(Long id) {
        pedidos.add(id);
    }

    public void cancelPedido(Long id) {
        pedidos.remove(id);
    }
}
