package demoqa.utils;

import demoqa.models.ConfigData;

import java.nio.file.Path;
import java.nio.file.Paths;

import static demoqa.utils.LoggerUtils.logMethod;

public class ConfigDataUtils {
    private static final Path PATH_TO_JSON_CONFIG_DATA = Paths.get("src/main/resources/ConfigData.json");

    public static ConfigData getBrowserConfig() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName);
        return JsonUtils.getObjectFromJson(PATH_TO_JSON_CONFIG_DATA.toString(), ConfigData.class);
    }
}