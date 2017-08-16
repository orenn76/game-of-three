package com.ninyo.playerb.client;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static com.ninyo.playerb.client.PlayerBClient.PATH;

@Path(PATH)
public interface PlayerBClient {

    String PATH = "/player-b";

    @GET
    @Consumes({"text/plain"})
    @Produces({"application/json"})
    public abstract Response play(@QueryParam("number") int paramInt);
}
