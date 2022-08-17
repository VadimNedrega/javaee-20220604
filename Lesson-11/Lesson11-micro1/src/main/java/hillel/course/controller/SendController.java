package hillel.course.controller;

import hillel.course.data.calc_kafka_dto.CalcKafkaDTO;
import hillel.course.data.entity.Calculation;
import hillel.course.data.repository.CalculationRepository;
import hillel.course.service.KafkaConsumer;
import hillel.course.service.KafkaProducer;
import hillel.course.service.KafkaTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class SendController {

    private final Logger log = LoggerFactory.getLogger(SendController.class);

    private final KafkaProducer kafkaProducer;
    private final KafkaConsumer kafkaConsumer;

    @Autowired
    private final CalculationRepository calculationRepository;


    private Calculation calculation;

    public SendController(KafkaProducer kafkaProducer, KafkaConsumer kafkaConsumer, CalculationRepository calculationRepository) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaConsumer = kafkaConsumer;
        this.calculationRepository = calculationRepository;
    }

    @PostMapping(path = "/startCalculation")
    public void sendMessageToTopic1(@RequestBody CalcKafkaDTO calcKafkaDTO) {
        calculation = new Calculation();
        calculation.setNumber1(calcKafkaDTO.getNumber1());
        calculation.setNumber2(calcKafkaDTO.getNumber2());
        calculation.setDateStart(new Date(System.currentTimeMillis()));
        calculationRepository.save(calculation);

        calcKafkaDTO.setId(calculation.getId());

        log.info("Request to send message ->  " + calcKafkaDTO.getId());
        kafkaProducer.send(KafkaTopic.TOPIC1, calcKafkaDTO.toString());
    }

    @PutMapping(path = "/statusCalculation/{id}")
    public Calculation updateCalculation(@PathVariable int id) {
        calculation = calculationRepository.getCalculationById(id);

        for (int i = 0; i < kafkaConsumer.getStatusCalculationList().size(); i++) {
            if (calculation.getId() == kafkaConsumer.getStatusCalculationList().get(i).getId()) {
                calculation.setDateFinish(new Date(System.currentTimeMillis()));
                calculation.setResult(kafkaConsumer.getStatusCalculation(i).getResult());
                calculationRepository.save(calculation);
            }
        }

        return calculation;
    }
}
