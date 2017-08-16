package com.ninyo.playerb.service;

import com.ninyo.player.utils.NumberUtils;
import com.ninyo.playera.client.PlayerAClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlayerBServiceImpl implements PlayerBService {

    @Autowired
    PlayerAClient playerAClient;

    @Override
    public void play(Integer number) {
        if (number == null) {
            number = NumberUtils.generateNumberBiggerOrEqualsTwo();
            log.info("Player B - generated a number, sending: " + number);
            playerAClient.play(number);
        } else {
            log.info("Player B - received: " + number);
            int[] operationAndNumberDivisibleByThree = NumberUtils.getOperationAndNumberDivisibleByThree(number);
            int numberDividedByThree = operationAndNumberDivisibleByThree[1] / 3;
            log.info("Player B - added: " + operationAndNumberDivisibleByThree[0]);

            if (numberDividedByThree == 1) {
                log.info("Player B - wins!!!");
            } else {
                log.info("Player B - divided by three, sending result: " + numberDividedByThree);
                playerAClient.play(numberDividedByThree);
            }
        }
    }
}