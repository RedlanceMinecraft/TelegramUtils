package org.redlance.tgutils.utils;

import it.tdlight.tdnative.NativeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TgUtilsLogger implements NativeClient.LogMessageHandler {
    public static final Logger LOGGER = LoggerFactory.getLogger("tgutils");

    @Override
    public void onLogMessage(int verbosityLevel, String message) {
        switch (verbosityLevel) {
            case -1:
            case 0:
            case 1:
                TgUtilsLogger.LOGGER.error(message);
                break;
            case 2:
                TgUtilsLogger.LOGGER.warn(message);
                break;
            case 3:
                TgUtilsLogger.LOGGER.info(message);
                break;
            case 4:
                TgUtilsLogger.LOGGER.debug(message);
                break;
            default:
                TgUtilsLogger.LOGGER.trace(message);
                break;
        }
    }
}
