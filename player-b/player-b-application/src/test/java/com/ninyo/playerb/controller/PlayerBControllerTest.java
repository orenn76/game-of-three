package com.ninyo.playerb.controller;

import com.ninyo.playerb.service.PlayerBService;
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
public class PlayerBControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerBService service;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("routesFilePath", "");
    }

    @Test
    public void playShouldReturnOk() throws Exception {
        this.mockMvc.perform(get("/player-b")).andExpect(status().isOk());
    }
}