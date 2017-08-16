package com.ninyo.playera.controller;

import com.ninyo.playera.service.PlayerAService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PlayerAController {

    @Autowired
    private PlayerAService playerAService;

    @RequestMapping(value = {"/player-a"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public void play(@RequestParam(value = "number", required = false) Integer number) {
        this.playerAService.play(number);
    }
}
