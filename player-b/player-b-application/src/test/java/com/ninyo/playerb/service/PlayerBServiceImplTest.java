package com.ninyo.playerb.service;

import ch.qos.logback.classic.Level;
import com.codereligion.cherry.junit.logback.LogRecorder;
import com.codereligion.cherry.junit.logback.LogSpec;
import com.ninyo.playera.client.PlayerAClient;
import com.ninyo.playera.client.PlayerAClientFactory;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static com.codereligion.cherry.test.hamcrest.logback.LoggingEventHasMessage.hasMessage;
import static org.junit.Assert.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@RunWith(SpringRunner.class)
public class PlayerBServiceImplTest {

    @Rule
    public final LogRecorder logRecorder = LogRecorder.expectedLogs(new LogSpec(PlayerBServiceImpl.class, Level.INFO));

    @Test
    @Ignore("this should only be executed manually")
    public void shouldLogEvents() {
        // given
        PlayerAClient playerAClient = new PlayerAClientFactory().createClient("http://localhost:8080");
        PlayerBServiceImpl playerBServiceImpl = new PlayerBServiceImpl();
        setField(playerBServiceImpl, "playerAClient", playerAClient);

        // when
        playerBServiceImpl.play(168);

        // then
        assertThat(logRecorder.events().get(0), hasMessage("Player B - received: 168"));
        assertThat(logRecorder.events().get(1), hasMessage("Player B - added: 0"));
        assertThat(logRecorder.events().get(2), hasMessage("Player B - divided by three, sending result: 56"));
    }
}