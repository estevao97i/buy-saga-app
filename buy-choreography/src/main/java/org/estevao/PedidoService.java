package org.estevao;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Set;

@ApplicationScoped
public class PedidoService {

    public Set<Long> id;

    public void newPedido(Long id) {
        this.id.add(id);
    }

    public void removePedido(Long id) {
        this.id.remove(id);
    }

}
