package trade.engine.kafka.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import trade.engine.kafka.model.Trade;

@Service
public class KafkaProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, Trade> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Trade> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Trade data){

        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<Trade> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        kafkaTemplate.send(message);
    }
}
