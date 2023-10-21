package baseball;

import java.util.List;

public class BaseballGame {
    private final int computerNumber;

    public BaseballGame(int computerNumber) {
        this.computerNumber = computerNumber;
    }

    public BaseballGameResult play(int inputNumber) {
        if (computerNumber == inputNumber) {
            int numberLength = String.valueOf(inputNumber).length();
            return new BaseballGameResult(numberLength, 0);
        }

        return getBaseBallGameResult(inputNumber);
    }

    private BaseballGameResult getBaseBallGameResult(int inputNumber) {
        int[] computerNumberArray = Util.splitAndGetIntArray(computerNumber);
        int[] inputNumberArray = Util.splitAndGetIntArray(inputNumber);

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < inputNumberArray.length; i++) {
            strike += isStrike(computerNumberArray, inputNumberArray, i) ? 1 : 0;
            ball += isBall(computerNumberArray, inputNumberArray, i) ? 1 : 0;
        }

        return new BaseballGameResult(strike, ball);
    }

    private boolean isBall(int[] computerNumberArray, int[] inputNumberArray, int i) {
        List<Integer> removedComputerNumberList = Util.removeAndGetList(computerNumberArray, i);
        return removedComputerNumberList.contains(inputNumberArray[i]);
    }

    private boolean isStrike(int[] computerNumberArray, int[] inputNumberArray, int i) {
        return inputNumberArray[i] == computerNumberArray[i];
    }
}
