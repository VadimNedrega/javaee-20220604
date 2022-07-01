package hillel.course.spring_data_jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "towns")
@NoArgsConstructor
@Getter
@Setter
public class Town {
    @Id
    @Column(name = "town_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer townId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "phoneCode", unique = true)
    private String phoneCode;


    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region region;

    public Town(String name, String phoneCode) {
        this.name = name;
        this.phoneCode = phoneCode;
    }

    @Override
    public String toString() {
        return "Town{" +
                "townId=" + townId +
                ", name='" + name + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                ", region=" + region +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Town town = (Town) o;
        return townId != null && Objects.equals(townId, town.townId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}