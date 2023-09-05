package org.estevao;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("compra-orquestrada")
public class CompraOrquestradaResource {

    @Inject
    public CreditoService creditoService;

    @Inject
    public PedidoService pedidoService;

    public Response saga() {

        return Response.ok().build();
    }

    public void comprar(Long id, int valor) {
        pedidoService.newPedido(id);
        try {
            creditoService.newPedidoValor(id, valor);
        } catch (IllegalStateException e) {
            pedidoService.cancelPedido(id);
            System.err.println("Pedido" + id + "cancelado no valor de: " + valor);
        }
    }


}