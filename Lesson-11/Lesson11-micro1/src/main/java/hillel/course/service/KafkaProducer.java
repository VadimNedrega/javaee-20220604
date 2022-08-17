package hillel.course.service;

import hillel.course.data.calc_kafka_dto.CalcKafkaDTO;
import hillel.course.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<Object, Object> template;

    public void send(KafkaTopic topic, String message) {
        log.info("Send message to Kafka ->  " + message);
        template.send(topic.getTopicName(), new Message(message));
    }
}
