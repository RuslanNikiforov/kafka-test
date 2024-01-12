package koda.kafkaTest.service;

import koda.kafkaTest.messages.Notice;
import koda.kafkaTest.messages.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "multiType", groupId = "multiTypeGroup")
@Log4j2
public class MultiTypeKafkaListener {

    @KafkaHandler
    public void handleNotice(Notice notice) {
        log.info("Notice received -> " + notice);
    }

    @KafkaHandler
    public void handleUserInfo(User user) {
        log.info("UserInfoMessage received -> " + user);
    }

    @KafkaHandler(isDefault = true)
    public void handleOtherObject(Object message) {
        log.info("Unknown object received -> " + message);
    }
}
