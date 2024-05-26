package org.telegram.mybot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Service
public class CallbackQueryHandlerService {

    public BotApiMethod<?> processCallbackQuery(CallbackQuery callbackQuery) {
        return null;
    }
}
