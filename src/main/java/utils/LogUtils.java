//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {
    private static final Logger LOGGER = LogManager.getLogger(LogUtils.class);

    private LogUtils() {
    }

    public static void logAction(String action) {
        LOGGER.info("Action performed: {}", action);
    }

    public static void logError(String error) {
        LOGGER.error("Error occurred: {}", error);
    }
}
