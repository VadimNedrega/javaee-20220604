package hillel.course.hibernate.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "cities")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class City implements Serializable {

    @Serial
    private static final long serialVersionUID = -1238070786993154476L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    public City(String name) {
        this.name = name;
    }
}
