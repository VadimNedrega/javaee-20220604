package hillel.course.spring_data_jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "regions")
@NoArgsConstructor
@Getter
@Setter
public class Region {
    @Id
    @Column(name = "region_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regionId;

    @Column(name = "name", unique = true)
    private String name;


    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @OneToMany(mappedBy = "region", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Set<Town> towns;

    public Region(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Region region = (Region) o;
        return regionId != null && Objects.equals(regionId, region.regionId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}