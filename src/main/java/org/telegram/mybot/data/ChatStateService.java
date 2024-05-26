package org.telegram.mybot.data;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.mybot.util.BotState;

@Service
@RequiredArgsConstructor
public class ChatStateService {

    private final BotStateCash botStateCash;

    public BotState getCurrentState(long chatId) {
        return botStateCash.getStateById(chatId);
    }

    public void setCurrentState(long chatId, BotState botState) {
        botStateCash.setStateById(chatId, botState);
    }
}
