package impl;

import model.Text;
import model.Word;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task10 {

    public List<Map.Entry<Word, Integer>> getWordsListByFrequency(Text text) {
        List<Word> words = text.getAllWords();
        Map<Word, Integer> wordsFrequencyMap = new HashMap<>();
        for (Word word : words) {
            if (wordsFrequencyMap.containsKey(word)) {
                Integer currentWordFrequency = wordsFrequencyMap.get(word);
                wordsFrequencyMap.put(word, ++currentWordFrequency);
            } else {
                wordsFrequencyMap.put(word, 1);
            }
        }
        return wordsFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Word, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
    }

}
