package org.telegram.mybot.data;

import org.springframework.stereotype.Component;
import org.telegram.mybot.util.BotState;

import java.util.HashMap;
import java.util.Map;

@Component
public class BotStateCash {

    private final Map<Long, BotState> chatStates = new HashMap<>();

    public BotState getStateById(long chatId) {
        return chatStates.get(chatId);
    }

    public void setStateById(long chatId, BotState botState) {
        chatStates.put(chatId, botState);
    }
}
