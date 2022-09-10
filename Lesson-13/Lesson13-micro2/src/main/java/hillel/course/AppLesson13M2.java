package hillel.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class AppLesson13M2 extends SpringBootServletInitializer implements WebApplicationInitializer {
    private static final Logger log = LoggerFactory.getLogger(AppLesson13M2.class);


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppLesson13M2.class);
    }

    public static void main(String[] args) {
        log.info("Start main...");
        SpringApplication.run(AppLesson13M2.class, args);
        log.info("Finish main...");
    }
}
