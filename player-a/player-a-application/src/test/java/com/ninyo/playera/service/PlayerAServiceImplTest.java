package com.ninyo.playera.service;

import ch.qos.logback.classic.Level;
import com.codereligion.cherry.junit.logback.LogRecorder;
import com.codereligion.cherry.junit.logback.LogSpec;
import com.ninyo.playerb.client.PlayerBClient;
import com.ninyo.playerb.client.PlayerBClientFactory;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static com.codereligion.cherry.test.hamcrest.logback.LoggingEventHasMessage.hasMessage;
import static org.junit.Assert.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@RunWith(SpringRunner.class)
public class PlayerAServiceImplTest {

    @Rule
    public final LogRecorder logRecorder = LogRecorder.expectedLogs(new LogSpec(PlayerAServiceImpl.class, Level.INFO));

    @Test
    @Ignore("this should only be executed manually")
    public void shouldLogEvents() {
        // given
        PlayerBClient playerBClient = new PlayerBClientFactory().createClient("http://localhost:8090");
        PlayerAServiceImpl playerAServiceImpl = new PlayerAServiceImpl();
        setField(playerAServiceImpl, "playerBClient", playerBClient);

        // when
        playerAServiceImpl.play(168);

        // then
        assertThat(logRecorder.events().get(0), hasMessage("Player A - received: 168"));
        assertThat(logRecorder.events().get(1), hasMessage("Player A - added: 0"));
        assertThat(logRecorder.events().get(2), hasMessage("Player A - divided by three, sending result: 56"));
    }
}