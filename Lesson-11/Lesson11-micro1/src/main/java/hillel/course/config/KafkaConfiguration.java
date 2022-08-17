package hillel.course.config;

import hillel.course.service.KafkaTopic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {
    @Bean
    public NewTopic topic1() {
        return new NewTopic(KafkaTopic.TOPIC1.getTopicName(), 1, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic(KafkaTopic.TOPIC2.getTopicName(), 1, (short) 1);
    }
}
