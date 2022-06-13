package hillel.course.jdbc_example.entity;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Footballer {
    private int id;
    private String name;
    private String surname;
    private String team;
    private String position;
    private int salary;
}
