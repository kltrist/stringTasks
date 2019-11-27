package impl;

import model.Sentence;
import model.Text;
import model.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task1 {

    public List<Sentence> getSentencesWithSameWords(Text text) {
        List<Sentence> sentencesWithSameWords = new ArrayList<>();

        for (Sentence sentence : text.getSentences()) {
            Map<Word, Long> wordFrequency = new HashMap<>();
            boolean isSentenceHaveSameWords = false;

            for (Word word : sentence.getWords()) {
                Long frequencyCount = wordFrequency.get(word);

                if (wordFrequency.get(word) != null) {
                    isSentenceHaveSameWords = true;
                    break;
                } else
                    wordFrequency.put(word, 1L);

            }
            if (isSentenceHaveSameWords)
                sentencesWithSameWords.add(sentence);
        }
        return sentencesWithSameWords;
    }

}
