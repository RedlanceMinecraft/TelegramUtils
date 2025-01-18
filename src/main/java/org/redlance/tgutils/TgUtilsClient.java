package org.redlance.tgutils;

import it.tdlight.client.AuthenticationSupplier;
import it.tdlight.client.SimpleTelegramClient;
import it.tdlight.client.TDLibSettings;
import it.tdlight.jni.TdApi;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class TgUtilsClient {
    private final CompletableFuture<SimpleTelegramClient> client;

    public TgUtilsClient(Path sessionPath, AuthenticationSupplier<?> authentication) {
        this.client = TelegramUtils.login(sessionPath, authentication);
    }

    public TgUtilsClient(TDLibSettings settings, AuthenticationSupplier<?> authentication) {
        this.client = TelegramUtils.login(settings, authentication);
    }

    /**
     * Boosty returns username instead of id, so I use this
     * @param username Telegram username
     */
    public CompletableFuture<TdApi.Chat> getChatByUsernameAsync(String username) {
        return this.client.thenCompose(client ->
                client.send(new TdApi.SearchPublicChat(username))
        );
    }

    /**
     * Boosty returns username instead of id, so I use this
     * @param username Telegram username
     */
    public TdApi.Chat getChatByUsername(String username) {
        return getClient().send(new TdApi.SearchPublicChat(username)).join();
    }

    /**
     * Retrieving a webapp link
     * @param botId Telegram bot id
     * @param url Base webapp url
     */
    public CompletableFuture<TdApi.WebAppInfo> getWebAppInfoAsync(long botId, String url) {
        return this.client.thenCompose(client ->
                client.send(new TdApi.OpenWebApp(botId, botId, url, TelegramUtils.DEFAULT_THEME, null, 0, null))
        );
    }

    /**
     * Retrieving a webapp link
     * @param botId Telegram bot id
     * @param url Base webapp url
     */
    public TdApi.WebAppInfo getWebAppInfo(long botId, String url) {
        return getClient().send(new TdApi.OpenWebApp(botId, botId, url, TelegramUtils.DEFAULT_THEME, null, 0, null)).join();
    }

    /**
     * @return Telegram client
     */
    public SimpleTelegramClient getClient() {
        return this.client.join();
    }
}
