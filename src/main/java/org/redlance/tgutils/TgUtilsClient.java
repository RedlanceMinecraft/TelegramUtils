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
    public TdApi.Chat getChatByUsername(String username) {
        return getClient().send(new TdApi.SearchPublicChat(username)).join();
    }

    /**
     * Retrieving a webapp link
     * @param botId Telegram bot id
     */
    public TdApi.WebAppInfo getWebAppInfo(long botId) {
        TdApi.UserFullInfo info = getClient().send(new TdApi.GetUserFullInfo(botId)).join();
        if (info.botInfo.menuButton == null) {
            return null;
        }
        return getClient().send(new TdApi.OpenWebApp(botId, botId, info.botInfo.menuButton.url, TelegramUtils.DEFAULT_THEME, null, 0, null)).join();
    }

    /**
     * @return Telegram client
     */
    public SimpleTelegramClient getClient() {
        return this.client.join();
    }
}
