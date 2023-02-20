package ru.kata.service.interfaces;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface ConsumerService {
    public void consumeTextMessageUpdates(Update update);
}
