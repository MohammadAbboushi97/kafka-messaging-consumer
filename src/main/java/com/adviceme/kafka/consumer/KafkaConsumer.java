package com.adviceme.kafka.consumer;

import com.adviceme.kafka.consumer.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

public class KafkaConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    private final EmailServiceImpl emailService;

    public KafkaConsumer(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(groupId = "group-id-json-1", topics = "netsurfingzone-topic-1", containerFactory = "kafkaListenerContainerFactory")
    public void receivedMessage(@Payload User msg, @Headers MessageHeaders headers) throws JsonProcessingException {
       emailService.sendSimpleMessage(msg);
    }
}
