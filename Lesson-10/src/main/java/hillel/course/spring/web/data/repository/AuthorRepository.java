package hillel.course.spring.web.data.repository;

import hillel.course.spring.web.data.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Author findAuthorByName(String name);

    Author findById(int id);
}
