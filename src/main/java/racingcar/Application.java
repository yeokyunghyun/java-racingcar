package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        //사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
        int tryNum = Integer.parseInt(Console.readLine());

        //자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
        String carSplit[] = carNames.split(",");
        Car cars[] = new Car[carSplit.length];

        int idx = 0;
        for(String carName : carSplit) {
            if(carName.length() > 5) throw new IllegalArgumentException();
            cars[idx++] = new Car(carName, 0);
        }

        System.out.println("실행 결과");
        //주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
        for(int i = 0; i < tryNum; ++i) {
            Arrays.stream(cars).forEach(car -> car.move(Randoms.pickNumberInRange(0,9)));
            Arrays.stream(cars).forEach(car -> {System.out.println(car.toString());});
            System.out.println();
        }

        int winnerScore = Arrays.stream(cars).mapToInt(car -> car.getLocation()).max().orElse(0);
        String winnerNames[] = Arrays.stream(cars).filter(car -> car.isWinner(winnerScore)).map(car -> car.getName()).toArray(String[]::new);

        //자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
        //우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
        String finalWinners = String.join(", ", winnerNames);
        System.out.print(String.format("최종 우승자 : %s", finalWinners));
    }

    private static class Car {
        private String name;
        private int location;

        public Car(String name, int location) {
            //사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
            if(name.isEmpty()) throw new IllegalArgumentException();
            this.name = name;
            this.location = location;
        }

        //전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 5
        public void move(int randomNum) {
            if(randomNum >= 4) this.location += 1;
        }

        public int getLocation() {
            return this.location;
        }

        private String makeLine() {
            String result = "";
            for(int i = 0; i < this.location; ++i) {
                result += "-";
            }
            return result;
        }

        public boolean isWinner(int maxScore) {
            return maxScore == this.location;
        }

        //각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 2
        public String toString() {
            return String.format("%s : %s", this.name, makeLine());
        }

        public String getName() {
            return this.name;
        }
    }
}
