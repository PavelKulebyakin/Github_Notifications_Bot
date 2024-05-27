package org.telegram.mybot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.mybot.bot.GitHubNotificationBot;
import org.telegram.mybot.service.LoggingService;
import org.telegram.mybot.service.TelegramFacade;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.generics.WebhookBot;

@Configuration
@RequiredArgsConstructor
public class WebhookBotConfig {

    private final TelegramProperties properties;

    @Bean
    public SetWebhook setWebhook() {
        return SetWebhook.builder().url(properties.getWebhookPath()).build();
    }

    @Bean
    public WebhookBot telegramBot(SetWebhook setWebhook, TelegramFacade updateHandler, LoggingService log) {
        return new GitHubNotificationBot(setWebhook, properties.getBotToken(), properties.getBotUsername(),
                properties.getWebhookPath(), updateHandler, log);
    }
}
