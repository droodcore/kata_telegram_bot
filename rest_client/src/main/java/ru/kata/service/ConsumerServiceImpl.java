package ru.kata.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.kata.service.interfaces.ConsumerService;
import ru.kata.service.interfaces.MainService;


@Log4j2
@AllArgsConstructor
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final MainService mainService;
    @Override
    @KafkaListener(topics = "text_msg_topic", groupId = "group_id")
    public void consumeTextMessageUpdates(Update update) {
        log.debug("NODE: text message received");

        mainService.processTextMessage(update);
    }
}
