package org.telegram.mybot.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@Log4j2
public class LoggingService {
    public void logException(TelegramApiException e) {
        log.error(e);
    }
}
