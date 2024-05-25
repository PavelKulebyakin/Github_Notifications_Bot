package org.telegram.mybot.config;

import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Component
@FieldDefaults(level = PRIVATE)
public class TelegramProperties {

    @Value("${telegram.webhook-path}")
    String webhookPath;
    @Value("${telegram.bot.username}")
    String botUsername;
    @Value("${telegram.bot.token}")
    String botToken;
}
