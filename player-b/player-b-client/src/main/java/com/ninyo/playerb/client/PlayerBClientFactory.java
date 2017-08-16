package com.ninyo.playerb.client;

import com.ninyo.player.client.RestClientFactory;

public class PlayerBClientFactory {
    public PlayerBClient createClient(String serviceUrl) {
        return RestClientFactory.createClient(PlayerBClient.class, serviceUrl);
    }
}
