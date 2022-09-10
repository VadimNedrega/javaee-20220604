package hillel.course.repo;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class TimeRepo {
    public String getCurrentTime() {
        return new Date().toString();
    }
}
