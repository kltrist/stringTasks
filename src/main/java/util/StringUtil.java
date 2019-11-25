package util;

import model.Text;
import model.Word;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringUtil {

    public static Map<Word, Long> getWordFrequency(Text text) {
        Map<Word, Long> frequency = new HashMap<>();

        text.getAllWords().forEach(word -> {
            Long count = frequency.get(word);
            if (count != null) {
                frequency.put(word, count + 1);
            }
            frequency.put(word, 1L);
        });

        return frequency.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> {
                            throw new IllegalStateException();
                        },
                        LinkedHashMap::new
                ));

    }


    public static String firstLetterToUpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }


}
