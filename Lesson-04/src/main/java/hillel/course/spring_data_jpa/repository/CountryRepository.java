package hillel.course.spring_data_jpa.repository;

import hillel.course.spring_data_jpa.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
    List<Country> findCountryByCountryId(Integer id);

    List<Country> findCountryByName(String name);
}
