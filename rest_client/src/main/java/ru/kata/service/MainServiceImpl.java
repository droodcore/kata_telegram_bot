package ru.kata.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.kata.service.interfaces.MainService;
import ru.kata.service.interfaces.ProducerService;


@Log4j2
@AllArgsConstructor
@Service
public class MainServiceImpl implements MainService {

    private final ProducerService producerService;


    @Override
    public void processTextMessage(Update update) {

        var chatId = update.getMessage().getChatId();
        sendAnswer("Hello from REST Client", chatId);
    }

    private void sendAnswer(String output, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(output);
        producerService.producerAnswer(sendMessage);
    }


//    private String help() {
//        return "Cписок доступных команд: \n"
//                + "/cancel - отмена выполнения текущей команды; \n"
//                + "/registration - регистрация пользователя.";
//    }

//


}
