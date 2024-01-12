package koda.kafkaTest.controller;

import koda.kafkaTest.messages.User;
import koda.kafkaTest.service.MessageProducer;
import koda.kafkaTest.service.MultiTypeKafkaListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilmController {

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private MultiTypeKafkaListener multiTypeKafkaListener;

    @PostMapping("/film/send")
    public void sendMessage(@RequestBody User message) {
        messageProducer.sendMessage(message);
    }

    @PostMapping("/film/send/MultiType")
    public void sendMultiTypeMessage() {
        messageProducer.sendMultiTypeMessages();
    }

    /*@GetMapping("/conf/allTopics")
    public void getTopics() {
        multiTypeKafkaListener.getTopics().forEach(System.out::println);
    }

     */
}
