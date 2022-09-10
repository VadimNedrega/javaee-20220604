package hillel.course.controller;

import hillel.course.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    private final Logger log = LoggerFactory.getLogger(TimeController.class);

    @Autowired
    private TimeService timeService;


    @PostMapping("/getServerTime")
    public String getTime() {
        return timeService.getCurrentTime();
    }
}
