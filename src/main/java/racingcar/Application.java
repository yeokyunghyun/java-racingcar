package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");

        //사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
        int tryNum = Integer.parseInt(Console.readLine());
        

    }

    private static class Car {
        private String name;
        private int location;

        public Car(String name, int cnt) {
            this.name = name;
            this.location = location;
        }

    }
}
