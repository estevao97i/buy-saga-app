package org.estevao;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("compra-orquestrada")
public class CompraOrquestradaResource {

    @Inject
    public CreditoService creditoService;

    @Inject
    public PedidoService pedidoService;


}
