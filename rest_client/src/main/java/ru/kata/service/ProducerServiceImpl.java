package ru.kata.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.kata.service.interfaces.ProducerService;


@Service
public class ProducerServiceImpl implements ProducerService {

    private static final String ANSWER_SEND_TOPIC = "answer_msg_topic";
    private final KafkaTemplate<String, SendMessage> kafkaTemplate;

    public ProducerServiceImpl(KafkaTemplate<String, SendMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void producerAnswer(SendMessage sendMessage) {
        kafkaTemplate.send(ANSWER_SEND_TOPIC, sendMessage);
    }
}
