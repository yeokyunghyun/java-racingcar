package racingcar.domain;

public class Car {
    private String name;
    private int location;

    public Car(String name, int location) {
        // 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
        if (name.length() > 5 || name.isEmpty()) throw new IllegalArgumentException("차 이름은 다섯 글자 이하여야 합니다.");
        if (name.isEmpty()) throw new IllegalArgumentException("차 이름을 작성해주세요.");
        this.name = name;
        this.location = location;
    }

    // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 5
    public void move(int randomNum) {
        if (randomNum >= 4) this.location += 1;
    }



    private String makeLine() {
        String result = "";
        for (int i = 0; i < this.location; ++i) {
            result += "-";
        }
        return result;
    }

    public boolean isWinner(int maxScore) {
        return maxScore == this.location;
    }

    // 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 2
    public String toString() {
        return String.format("%s : %s", this.name, makeLine());
    }

    public String getName() {
        return this.name;
    }
    public int getLocation() {
        return this.location;
    }
}
