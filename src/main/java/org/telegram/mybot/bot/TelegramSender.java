package org.telegram.mybot.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface TelegramSender {

    void sendMessage(SendMessage message);
}
