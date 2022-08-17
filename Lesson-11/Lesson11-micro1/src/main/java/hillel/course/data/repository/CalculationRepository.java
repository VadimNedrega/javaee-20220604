package hillel.course.data.repository;

import hillel.course.data.entity.Calculation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends CrudRepository<Calculation, Integer> {
    Calculation getCalculationById(int id);
}
