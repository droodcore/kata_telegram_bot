package ru.kata.service.interfaces;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateProducer {
    void produce(Update update);
}
