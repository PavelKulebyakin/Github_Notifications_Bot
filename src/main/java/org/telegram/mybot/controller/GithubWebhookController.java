package org.telegram.mybot.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telegram.mybot.bot.TelegramSender;
import org.telegram.mybot.model.Payload;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@RestController
@RequiredArgsConstructor
@RequestMapping("/github")
public class GithubWebhookController {

    private final TelegramSender telegramSender;

    @PostMapping(path = "/{chatId}", consumes = "application/json")
    public ResponseEntity<String> handleWebhookPayload(@PathVariable long chatId, @RequestHeader("X-GitHub-Event") String event, @RequestBody Payload payload) {
//        System.out.println(event);
//        System.out.println(payload.toString());
        telegramSender.sendMessage(SendMessage.builder().chatId(chatId).text(event).build());
        telegramSender.sendMessage(SendMessage.builder().chatId(chatId).text(payload.toString()).build());
        return ResponseEntity.ok().body("Payload received");
    }

}
