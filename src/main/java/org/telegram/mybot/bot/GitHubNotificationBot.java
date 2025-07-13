package org.telegram.mybot.bot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.mybot.service.LoggingService;
import org.telegram.mybot.service.TelegramFacade;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GitHubNotificationBot extends SpringWebhookBot implements TelegramSender {

    @Getter
    String botUsername;
    @Getter
    String botPath;
    TelegramFacade telegramFacade;
    LoggingService loggingService;

    public GitHubNotificationBot(SetWebhook setWebhook, String botToken, String botUsername, String botPath,
                                 TelegramFacade telegramFacade, LoggingService loggingService) {
        super(setWebhook, botToken);
        this.botUsername = botUsername;
        this.botPath = botPath;
        this.telegramFacade = telegramFacade;
        this.loggingService = loggingService;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return telegramFacade.processUpdate(update);
    }

    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            this.execute(sendMessage);
        } catch (TelegramApiException e) {
            loggingService.logException(e);
        }
    }
}
