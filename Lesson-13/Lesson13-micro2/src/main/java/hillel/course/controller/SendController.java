package hillel.course.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SendController {

    @Autowired
    TimeController timeController;

    @GetMapping(path = "/showTime")
    public String sendMessageToTopic1(Model model) {
        model.addAttribute("time", timeController.getTime());
        return "showTime";
    }


}
