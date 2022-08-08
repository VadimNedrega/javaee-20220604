package hillel.course.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class AppLesson10 {
    private static final Logger log = Logger.getLogger(AppLesson10.class.getName());

    public static void main(String[] args) {
        log.info("Start main...");
        SpringApplication.run(AppLesson10.class, args);
        log.info("Finish main...");
    }
}
