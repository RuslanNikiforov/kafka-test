package koda.kafkaTest.config;

import koda.kafkaTest.messages.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;

@Configuration
public class ProducerKafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaAddress;

    @Bean
    public ProducerFactory<String, User> defaultProducerFactory() {
        HashMap<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(producerProperties);
    }

    @Bean
    public ProducerFactory<String, Object> multiTypeProducerFactory() {
        HashMap<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaAddress);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        producerProperties.put(JsonSerializer.TYPE_MAPPINGS, "notice:koda.kafkaTest.messages.Notice, " +
                "user:koda.kafkaTest.messages.User");
        return new DefaultKafkaProducerFactory<>(producerProperties);
    }


    @Bean
    public KafkaTemplate<String, User> kafkaTemplate() {
        return new KafkaTemplate<>(defaultProducerFactory());
    }

    @Bean
    public KafkaTemplate<String, Object> multipleKafkaTemplate() {
        return new KafkaTemplate<>(multiTypeProducerFactory());
    }
}
