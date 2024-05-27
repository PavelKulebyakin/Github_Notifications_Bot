package org.telegram.mybot.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.telegram.mybot.data.ChatStateService;
import org.telegram.mybot.util.BotState;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static java.text.MessageFormat.format;
import static lombok.AccessLevel.PRIVATE;
import static org.telegram.mybot.util.BotMessages.*;
import static org.telegram.mybot.util.BotState.*;
import static org.telegram.mybot.util.Command.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class MessageHandlerService {

    EventHandlerService eventHandler;
    ChatStateService stateService;

    public BotApiMethod<?> processMessage(Message message) {

        String messageText = message.getText();
        long chatId = message.getChatId();
        if (stateService.getCurrentState(chatId) == null) {
            stateService.setCurrentState(chatId, START_STATE);
        }
        BotState botState = stateService.getCurrentState(chatId);
        BotApiMethod<?> response = null;

        switch (botState) {
            case START_STATE -> {
                if (START_COMMAND.equals(messageText)) {
                    response = executeStartCommand(chatId);
                    stateService.setCurrentState(chatId, DEFAULT_STATE);
                }
            }
            case DEFAULT_STATE -> {
                if (HELP_COMMAND.equals(messageText)) {
                    response = executeHelpCommand(chatId);
                }
                else if (ADD_COMMAND.equals(messageText)) {
                    response = executeAddCommand(chatId);
                    stateService.setCurrentState(chatId, ENTER_NAME_STATE);
                }
                else {
                    response = executeDefault(chatId);
                }
            }
            case ENTER_NAME_STATE -> {
                if (isValidRepositoryName(messageText)) {
                    response = executeEnterName(chatId, messageText);
                    stateService.setCurrentState(chatId, DEFAULT_STATE);
                } else {
                    response = executeInvalidName(chatId);
                }
            }
        }
        return response;
    }

    private SendMessage executeInvalidName(long chatId) {
        return getSendMessage(chatId, INCORRECT_NAME_MESSAGE);
    }

    private SendMessage executeEnterName(long chatId, String repositoryName) {
        String link = eventHandler.generateWebhookLink(repositoryName);
        return getSendMessage(chatId, format(ADD_MESSAGE_2, link));
    }

    private SendMessage executeDefault(long chatId) {
        return getSendMessage(chatId, DEFAULT_MESSAGE);
    }

    private SendMessage executeAddCommand(long chatId) {
        return getSendMessage(chatId, ADD_MESSAGE_1);
    }

    private SendMessage executeStartCommand(long chatId) {
        return getSendMessage(chatId, START_MESSAGE);
    }

    private SendMessage executeHelpCommand(long chatId) {
        return getSendMessage(chatId, HELP_MESSAGE);
    }

    private static SendMessage getSendMessage(long chatId, String message) {
        return SendMessage.builder().chatId(chatId).text(message).build();
    }

    public static boolean isValidRepositoryName(String repoName) {
        // Check if the repository name is not empty or length is within the allowed range
        if (repoName.isEmpty() || repoName.length() > 30) {
            return false;
        }
        // Check if the repository name contains only alphanumeric characters, hyphens, and underscores
        if (!repoName.matches("^[a-zA-Z0-9-_]+$")) {
            return false;
        }
        return true;
    }

}
