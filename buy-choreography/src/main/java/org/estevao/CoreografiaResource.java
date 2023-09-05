package org.estevao;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("coreografia")
public class CoreografiaResource {

    @Inject
    PedidoService pedidoService;

    @GET
    @Path("compra")
    @Produces(MediaType.TEXT_PLAIN)
    public Response saga() {

        Long id = 0L;

        pedidoService.newPedido(id++, 20D);
        pedidoService.newPedido(id++, 50D);
        pedidoService.newPedido(id++, 10D);
        pedidoService.newPedido(id++, 20D);
        pedidoService.newPedido(id++, 20D);

        return Response.ok().build();
    }

}
