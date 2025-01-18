package org.redlance.tgutils;

import it.tdlight.Init;
import it.tdlight.Log;
import it.tdlight.client.APIToken;
import it.tdlight.client.AuthenticationSupplier;
import it.tdlight.client.SimpleTelegramClient;
import it.tdlight.client.SimpleTelegramClientFactory;
import it.tdlight.client.TDLibSettings;
import it.tdlight.jni.TdApi;
import org.redlance.tgutils.utils.TgUtilsLogger;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class TelegramUtils {
    public static final APIToken API_TOKEN = new APIToken(21496123, "cb57ae3996c0ebdd2e24fea19f35879d");
    public static final TdApi.ThemeParameters DEFAULT_THEME = new TdApi.ThemeParameters(0x212121, 0x181818, 0x212121, 0x212121, 0xffffff, 0x8774e1, 0x8774e1, 0xaaaaaa, 0xff595a, 0xaaaaaa, 0x8774e1, 0x8774e1, 0xffffff);

    static {
        try {
            TgUtilsLogger.LOGGER.debug("Initializing tdlight...");

            Init.init();
            Log.setLogMessageHandler(1, new TgUtilsLogger());
        } catch (Throwable e) {
            throw new RuntimeException("Failed to initialize tdlight!", e);
        }
    }

    public static CompletableFuture<SimpleTelegramClient> login(Path sessionPath, AuthenticationSupplier<?> authentication) {
        TDLibSettings settings = TDLibSettings.create(TelegramUtils.API_TOKEN);
        settings.setDatabaseDirectoryPath(sessionPath.resolve("data"));
        settings.setDownloadedFilesDirectoryPath(sessionPath.resolve("downloads"));

        return TelegramUtils.login(settings, authentication);
    }

    @SuppressWarnings("resource")
    public static CompletableFuture<SimpleTelegramClient> login(TDLibSettings settings, AuthenticationSupplier<?> authentication) {
        CompletableFuture<SimpleTelegramClient> future = new CompletableFuture<>();

        SimpleTelegramClient client = new SimpleTelegramClientFactory().builder(settings).build(authentication);
        client.getMeAsync().thenRun(() -> future.complete(client));

        return future;
    }
}
