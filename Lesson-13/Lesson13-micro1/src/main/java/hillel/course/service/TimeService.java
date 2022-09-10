package hillel.course.service;

import hillel.course.repo.TimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepo timeRepo;

    public String getCurrentTime() {
        return timeRepo.getCurrentTime();
    }
}
