package com.ninyo.playera.client;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static com.ninyo.playera.client.PlayerAClient.PATH;

@Path(PATH)
public interface PlayerAClient {

    String PATH = "/player-a";

    @GET
    @Consumes({"text/plain"})
    @Produces({"application/json"})
    public abstract Response play(@QueryParam("number") int paramInt);
}
