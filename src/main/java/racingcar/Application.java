package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;
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
        List<Car> carList = Arrays.stream(carNames.split(",")).map(carName -> new Car(carName, 0)).toList();
        Cars cars = new Cars(carList);

        System.out.println("실행 결과");
        //주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
        for(int i = 0; i < tryNum; ++i) {
            cars.move(Randoms.pickNumberInRange(0,9));
            cars.print();
            System.out.println();
        }
        //자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
        //우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
        List<String> finalWinners = cars.findWinner();
        String result = finalWinners.stream().collect(Collectors.joining(", "));
        System.out.print(String.format("최종 우승자 : %s", result));
    }
}
