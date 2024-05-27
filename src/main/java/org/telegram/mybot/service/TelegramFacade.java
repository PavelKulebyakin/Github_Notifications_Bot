package org.telegram.mybot.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TelegramFacade {

    MessageHandlerService messageHandlerService;
    CallbackQueryHandlerService callbackQueryHandlerService;

    public BotApiMethod<?> processUpdate(Update update) {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            return callbackQueryHandlerService.processCallbackQuery(callbackQuery);
        }
        else if (update.hasMessage()) {
            Message message = update.getMessage();
            return messageHandlerService.processMessage(message);
        }
        return null;
    }
}
