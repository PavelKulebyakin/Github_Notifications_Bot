package org.telegram.mybot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.WebhookBot;

@RestController
@RequiredArgsConstructor
@RequestMapping("/webhook")
public class TelegramWebhookController {

    private final WebhookBot bot;

    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @PostMapping       // TODO change path
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return bot.onWebhookUpdateReceived(update);
    }
}
