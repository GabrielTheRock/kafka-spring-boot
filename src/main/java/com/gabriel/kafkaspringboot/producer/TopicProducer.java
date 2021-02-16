package com.gabriel.kafkaspringboot.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

    //Pega essa informação do application.properties
    @Value("${topic.name.producer}")
    private String topicName;

    //KafkaTemplate é a classe que faz o envio das mensagens para um tópico
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        log.info("Mensagem enviada: {}", message);
        kafkaTemplate.send(topicName, message);
    }

}
