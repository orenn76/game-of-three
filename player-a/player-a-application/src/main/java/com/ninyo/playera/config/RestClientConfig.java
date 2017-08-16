package com.ninyo.playera.config;

import com.ninyo.playerb.client.PlayerBClient;
import com.ninyo.playerb.client.PlayerBClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public PlayerBClient playerBClient(Jackson2ObjectMapperBuilder jacksonBuilder, @Value("${playerBClientUrl:http://localhost:8090}") String playerBClientUrl) {
        try {
            log.info("playerBClientUrl host: {}", playerBClientUrl);
            return new PlayerBClientFactory().createClient(playerBClientUrl);
        } catch (Throwable ex) {
            throw ex;
        }
    }
}
