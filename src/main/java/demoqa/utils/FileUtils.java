package demoqa.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    public static String readContent(String filePath) {
        String result = null;
        try {
            File file = new File(filePath);
            Path path = file.toPath();
            byte[] bytes = Files.readAllBytes(path);
            result = new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}