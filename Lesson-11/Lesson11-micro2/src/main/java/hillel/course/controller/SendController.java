package hillel.course.controller;

import hillel.course.data.StatusCalculation;
import hillel.course.service.KafkaConsumer;
import hillel.course.service.KafkaProducer;
import hillel.course.service.KafkaTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SendController {

    private final Logger log = LoggerFactory.getLogger(SendController.class);

    private final KafkaProducer kafkaProducer;
    private final KafkaConsumer kafkaConsumer;


    public SendController(KafkaProducer kafkaProducer, KafkaConsumer kafkaConsumer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaConsumer = kafkaConsumer;
    }

    @PostMapping(path = "/statusCalculation/{id}")
    public StatusCalculation sendMessageToTopic1(@PathVariable int id) {

        log.info("Request to send message ->  " + kafkaConsumer.getStatusCalculation(id));
        kafkaProducer.send(KafkaTopic.TOPIC2, String.valueOf(kafkaConsumer.getStatusCalculation(id)));

        return kafkaConsumer.getStatusCalculation(id);
    }


}
