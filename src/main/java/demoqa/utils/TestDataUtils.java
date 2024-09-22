package demoqa.utils;

import demoqa.models.TestData;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDataUtils {
    private static String randomName;
    private static final Path PATH_TO_JSON_TEST_DATA = Paths.get("src/test/resources/DemoQATestData.json");

    public static String getRandomName() {
        return randomName;
    }

    public static void setRandomName(String randomName) {
        TestDataUtils.randomName = randomName;
    }

    public static TestData getTestData() {
        return JsonUtils.getObjectFromJson(PATH_TO_JSON_TEST_DATA.toString(), TestData.class);
    }
}