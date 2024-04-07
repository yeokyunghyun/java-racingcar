package racingcar.domain;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(int randomNum) {
        cars.forEach(car -> car.move(randomNum));
    }

    public void print() {
        cars.forEach(car -> System.out.println(car.toString()));
    }

    private int getWinnerScore() {
        return cars.stream().mapToInt(car -> car.getLocation()).max().orElse(0);
    }

    public List<String> findWinner() {
        int winnerScore = getWinnerScore();
        return cars.stream().filter(car -> car.isWinner(winnerScore)).map(winner -> winner.getName()).toList();
    }
}
