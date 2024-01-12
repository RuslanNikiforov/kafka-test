package koda.kafkaTest.service;

import koda.kafkaTest.messages.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class MessageConsumer {

    @Qualifier(value = "consumerFactory")
    @Autowired
    ConsumerFactory<String, String> consumerFactory;

    @KafkaListener(topics = {"films", "abc", "wddaw", "pc"},
            containerFactory = "userInfoKafkaListenerContainerFactory")
    public void listenMessage(User message) {
        System.out.println("Message from group ex -> " + message);
    }

    public Set<String> getTopics() {
        return consumerFactory.createConsumer().listTopics().keySet();
    }
}
