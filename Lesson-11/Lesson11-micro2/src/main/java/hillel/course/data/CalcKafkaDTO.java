package hillel.course.data;

import org.springframework.stereotype.Component;

@Component
public class CalcKafkaDTO {
    private int id;
    private int number1;
    private int number2;

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("{\"id\":%d,\"number1\":%d,\"number2\":%d}", id, number1, number2);
    }
}
