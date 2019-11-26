package impl;

import model.Text;
import model.Word;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task7 {

    private static final Set<Integer> VOWELS = "aeiouуеыаоэяию".chars().boxed().collect(Collectors.toSet());

    public List<Word> getWordsSortByVowelsFractionAsc(Text text) {
        List<Word> allWords = text.getAllWords();

        Map<Word, Double> vowelCount = allWords.stream()
                .collect(Collectors.toMap(Function.identity(),
                        (Word word) -> (double) word.getCharSequence().chars().filter(VOWELS::contains).count() / word.getCharSequence().length()));

        Map<Word, Double> sortedVowelCount = vowelCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        return new ArrayList<>(sortedVowelCount.keySet());
    }
}
