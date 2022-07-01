package hillel.course.spring_data_jpa.repository;

import hillel.course.spring_data_jpa.entity.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends CrudRepository<Region, Integer> {
    List<Region> findRegionByRegionId(Integer id);

    List<Region> findRegionByName(String name);
}
