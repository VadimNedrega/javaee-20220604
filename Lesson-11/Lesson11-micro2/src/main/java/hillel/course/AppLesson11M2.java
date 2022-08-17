package hillel.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppLesson11M2 {
    private static final Logger log = LoggerFactory.getLogger(AppLesson11M2.class);

    public static void main(String[] args) {
        log.info("Start main...");
        SpringApplication.run(AppLesson11M2.class, args);
        log.info("Finish main...");
    }
}
