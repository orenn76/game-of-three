package com.ninyo.playera.controller;

import com.ninyo.playera.service.PlayerAService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PlayerAControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerAService service;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("routesFilePath", "");
    }

    @Test
    public void playShouldReturnOk() throws Exception {
        this.mockMvc.perform(get("/player-a")).andExpect(status().isOk());
    }
}