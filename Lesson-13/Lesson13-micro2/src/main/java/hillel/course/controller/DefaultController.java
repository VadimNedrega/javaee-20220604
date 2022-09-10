package hillel.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String getInfo() {
        return "Hello to Lesson-13-micro2!";
    }
}
