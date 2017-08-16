package com.ninyo.playera.client;

import com.ninyo.player.client.RestClientFactory;

public class PlayerAClientFactory {
    public PlayerAClient createClient(String serviceUrl) {
        return RestClientFactory.createClient(PlayerAClient.class, serviceUrl);
    }
}
