package demoqa.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    public static final String AQA_PREFIX = "aqa";
    private static final Random random = new Random();

    private RandomUtils() {
    }

    public static String getRandString(long charCount, String charSet, boolean usePrefix) {
        if ((charCount > AQA_PREFIX.length()) && usePrefix) {
            return genRandStrWithPrefix(AQA_PREFIX, charCount, charSet);
        } else {
            return generateRandStr(charCount, charSet);
        }
    }

    public static <T> T getRandListElem(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Collection must be defined and contains at least one element");
        }
        int randIndex = random.nextInt(list.size());
        return list.get(randIndex);
    }

    private static String generateRandStr(long charCount, String charSet) {
        if (charCount < 0) {
            throw new IllegalArgumentException("Characters count must be greater then 0");
        }
        if (StringUtils.isEmpty(charSet)) {
            throw new IllegalArgumentException("Characters set must be defined and contains more then 0 character");
        }
        var chars = Arrays.asList(charSet.split(""));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charCount; i++) {
            stringBuilder.append(getRandListElem(chars));
        }
        return stringBuilder.toString();
    }

    private static String genRandStrWithPrefix(String prefix, long charCount, String charSet) {
        return prefix + generateRandStr(Long.sum(-prefix.length(), charCount), charSet);
    }
}