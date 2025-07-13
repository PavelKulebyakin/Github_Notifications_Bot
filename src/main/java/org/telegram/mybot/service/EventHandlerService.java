package org.telegram.mybot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.mybot.config.GitHubProperties;

@Service
@RequiredArgsConstructor
public class EventHandlerService {

    private final GitHubProperties properties;

    public String generateWebhookLink(long chatId, String repositoryName) {
        return properties.getWebhookBasePath() + "/" + chatId;
    }
}
