package hillel.course.spring_data_jpa.repository;

import hillel.course.spring_data_jpa.entity.Town;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownRepository extends CrudRepository<Town, Integer> {
    List<Town> findTownByTownId(Integer id);

    List<Town> findTownByName(String name);
}
