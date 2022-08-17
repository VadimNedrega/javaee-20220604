package hillel.course.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hillel.course.data.CalcKafkaDTO;
import hillel.course.data.StatusCalculation;
import hillel.course.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@Service
public class KafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    private static final String TOPIC_2 = "calcSumma";

    private final ObjectMapper objectMapper = new ObjectMapper();


    private StatusCalculation statusCalculation;

    @Autowired
    private List<StatusCalculation> statusCalculationList;

    @KafkaListener(id = "consumer2", topics = TOPIC_2)
    public void listenTopic2(Message msg) {
        try {
            log.info("Received message from Kafka ->  " + objectMapper.writerFor(Message.class).writeValueAsString(msg));

            StringReader reader = new StringReader(msg.getMsg());
            CalcKafkaDTO calcKafkaDTO = objectMapper.readValue(reader, CalcKafkaDTO.class);

            statusCalculation = new StatusCalculation();
            statusCalculation.setId(calcKafkaDTO.getId());
            statusCalculation.setResult(calcKafkaDTO.getNumber1() + calcKafkaDTO.getNumber2());

            statusCalculationList.add(statusCalculation);

        } catch (IOException exception) {
            log.error(exception.getMessage());
        }
    }

    public StatusCalculation getStatusCalculation() {
        return statusCalculation;
    }

    public StatusCalculation getStatusCalculation(int id) {
        return statusCalculationList.get(id);
    }
}
