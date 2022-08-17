package hillel.course.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hillel.course.data.calc_kafka_dto.StatusCalculation;
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

    private static final String TOPIC_2 = "statusSumma";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private List<StatusCalculation> statusCalculationList;

    @KafkaListener(id = "consumer1", topics = TOPIC_2)
    public void listenTopic1(Message msg) {
        try {
            log.info("Received message from Kafka ->  " + objectMapper.writerFor(Message.class).writeValueAsString(msg));

            StringReader reader = new StringReader(msg.getMsg());
            StatusCalculation statusCalculation = objectMapper.readValue(reader, StatusCalculation.class);

            statusCalculationList.add(statusCalculation);

        } catch (IOException exception) {
            log.error(exception.getMessage());
        }
    }

    public StatusCalculation getStatusCalculation(int id) {
        return statusCalculationList.get(id);
    }

    public List<StatusCalculation> getStatusCalculationList() {
        return statusCalculationList;
    }
}
