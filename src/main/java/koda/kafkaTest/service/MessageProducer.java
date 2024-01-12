package koda.kafkaTest.service;

import koda.kafkaTest.messages.Notice;
import koda.kafkaTest.messages.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageProducer {

    private final String topicName = "multiType";

    @Autowired
    @Qualifier(value = "multipleKafkaTemplate")
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(User message) {
        kafkaTemplate.send(topicName, message);
        log.info("this message has been sent -> " + message + "from topic " + topicName);
    }

    public void sendMultiTypeMessages() {

        kafkaTemplate.send(topicName, new User("jauwdj", "Alex", 27));
        kafkaTemplate.send(topicName, new Notice("amd", 45000));
        kafkaTemplate.send(topicName, 123);


    }

}
