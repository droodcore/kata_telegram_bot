package ru.kata.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.kata.service.interfaces.UpdateProducer;

@Service
@Log4j2
public class UpdateProducerImpl implements UpdateProducer {

    private static final String TEXT_SEND_TOPIC = "text_msg_topic";

    private final KafkaTemplate<String, Update> kafkaTemplate;

    public UpdateProducerImpl(KafkaTemplate<String, Update> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void produce(Update update) {
      log.debug(update.getMessage().getText());
      kafkaTemplate.send(TEXT_SEND_TOPIC, update);
    }
}
