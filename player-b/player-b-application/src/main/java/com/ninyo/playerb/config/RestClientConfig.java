package com.ninyo.playerb.config;

import com.ninyo.playera.client.PlayerAClient;
import com.ninyo.playera.client.PlayerAClientFactory;
import com.ninyo.playerb.client.PlayerBClient;
import com.ninyo.playerb.client.PlayerBClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Slf4j
@Configuration
public class RestClientConfig {

    @Bean
    @Autowired
    public PlayerAClient playerBClient(Jackson2ObjectMapperBuilder jacksonBuilder, @Value("${playerBClientUrl:http://localhost:8080}") String playerAClientUrl) {
        try {
            log.info("playerAClientUrl host: {}", playerAClientUrl);
            return new PlayerAClientFactory().createClient(playerAClientUrl);
        } catch (Throwable ex) {
            throw ex;
        }
    }
}
