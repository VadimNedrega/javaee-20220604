package hillel.course.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Calculation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number1")
    private int number1;

    @Column(name = "number2")
    private int number2;

    @Column(name = "dateStart")
    private Date dateStart;

    @Column(name = "dateFinish")
    private Date dateFinish;

    @Column(name = "result")
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "id=" + id +
                ", number1=" + number1 +
                ", number2=" + number2 +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", result=" + result +
                '}';
    }
}
