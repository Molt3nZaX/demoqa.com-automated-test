package demoqa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LoggerUtils {
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.class);

    public static void logInfo(String name, String inClosingMethod) {
        logger.info(name + inClosingMethod);
    }

    public static void logMethod(String inClosingMethod) {
        logger.info("Method: " + inClosingMethod);
    }

    public static void logStepInfo(String name) {
        logger.info("Test step: " + name);
    }
}