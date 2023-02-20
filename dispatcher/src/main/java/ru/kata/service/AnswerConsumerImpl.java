package ru.kata.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.kata.controller.UpdateController;
import ru.kata.service.interfaces.AnswerConsumer;

@Service
public class AnswerConsumerImpl implements AnswerConsumer {
    private final UpdateController updateController;

    public AnswerConsumerImpl(UpdateController updateController) {
        this.updateController = updateController;
    }

    @Override
    @KafkaListener(topics = "answer_msg_topic", groupId = "group_id")
    public void consume(SendMessage sendMessage) {
      updateController.setView(sendMessage);
    }
}
