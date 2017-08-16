package com.ninyo.player.utils;

import java.util.concurrent.ThreadLocalRandom;

public class NumberUtils {
    public static int[] getOperationAndNumberDivisibleByThree(int number) {
        int[] operationAndNumberDivisibleByThree = new int[2];
        if ((number - 1) % 3 == 0) {
            operationAndNumberDivisibleByThree[0] = -1;
            operationAndNumberDivisibleByThree[1] = (number - 1);
        } else if ((number + 1) % 3 == 0) {
            operationAndNumberDivisibleByThree[0] = 1;
            operationAndNumberDivisibleByThree[1] = (number + 1);
        } else {
            operationAndNumberDivisibleByThree[0] = 0;
            operationAndNumberDivisibleByThree[1] = number;
        }
        return operationAndNumberDivisibleByThree;
    }

    public static int generateNumberBiggerOrEqualsTwo() {
        return ThreadLocalRandom.current().nextInt(2, Integer.MAX_VALUE);
    }
}
