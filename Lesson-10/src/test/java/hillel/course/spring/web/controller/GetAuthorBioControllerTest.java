package hillel.course.spring.web.controller;

import hillel.course.spring.web.data.entity.Author;
import hillel.course.spring.web.data.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootTest
public class GetAuthorBioControllerTest {

    @Test
    void checkAuthorBiography() {
        Author author = new Author();
        author.setBiography("Some biography");

        Assertions.assertNotNull(author.getBiography());
    }
}
