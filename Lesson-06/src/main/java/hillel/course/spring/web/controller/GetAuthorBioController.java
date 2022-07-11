package hillel.course.spring.web.controller;

import hillel.course.spring.web.data.entity.Author;
import hillel.course.spring.web.data.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GetAuthorBioController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/getBio/{name}")
    public String getName(@PathVariable(name = "name") String name, Model model) {
        Author author = authorRepository.findAuthorByName(name);
        model.addAttribute("model_name", author.getName());
        model.addAttribute("model_surname", author.getSurname());
        model.addAttribute("model_bio", author.getBiography());
        return "authorBio";
    }
}
