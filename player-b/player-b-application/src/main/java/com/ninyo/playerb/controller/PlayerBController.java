package com.ninyo.playerb.controller;

import com.ninyo.playerb.service.PlayerBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PlayerBController {

    @Autowired
    private PlayerBService playerBService;

    @RequestMapping(value = "/player-b", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void play(@RequestParam(value = "number", required = false) Integer number) {
        playerBService.play(number);
    }
}
