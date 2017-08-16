package com.ninyo.playera.service;

import com.ninyo.player.utils.NumberUtils;
import com.ninyo.playerb.client.PlayerBClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PlayerAServiceImpl implements PlayerAService {

    @Autowired
    PlayerBClient playerBClient;

    public void play(Integer number) {
        if (number == null) {
            number = NumberUtils.generateNumberBiggerOrEqualsTwo();
            log.info("Player A - generated a number, sending: " + number);
            this.playerBClient.play(number);
        } else {
            log.info("Player A - received: " + number);
            int[] operationAndNumberDivisibleByThree = NumberUtils.getOperationAndNumberDivisibleByThree(number.intValue());
            int numberDividedByThree = operationAndNumberDivisibleByThree[1] / 3;
            log.info("Player A - added: " + operationAndNumberDivisibleByThree[0]);
            if (numberDividedByThree == 1) {
                log.info("Player A - wins!!!");
            } else {
                log.info("Player A - divided by three, sending result: " + numberDividedByThree);
                this.playerBClient.play(numberDividedByThree);
            }
        }
    }
}
