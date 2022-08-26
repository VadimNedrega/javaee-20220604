package hillel.course.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class AppLesson06 {
    private static final Logger log = Logger.getLogger(AppLesson06.class.getName());

    public static void main(String[] args) {
        log.info("Start main...");
        SpringApplication.run(AppLesson06.class, args);
        log.info("Finish main...");
    }
}
