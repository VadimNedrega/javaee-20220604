package hillel.course.spring.web.controller.rest;

import hillel.course.spring.web.data.entity.Author;
import hillel.course.spring.web.data.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public List<Author> showAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author showAuthor(@PathVariable int id) {
        return authorRepository.findById(id);
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
        authorRepository.save(author);
        return author;
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        if (authorRepository.findById(id) == null) {
            throw new NoSuchElementException("There is no Author with id: " + id);
        }
        authorRepository.save(author);
        return author;
    }

    @DeleteMapping("/authors/{id}")
    public String deleteEmployee(@PathVariable int id) {
        if (authorRepository.findById(id) == null) {
            throw new NoSuchElementException("There is no Author with id: " + id);
        }
        Author author = authorRepository.findById(id);
        authorRepository.delete(author);
        return "Author with ID=" + id + " was deleted";
    }
}
