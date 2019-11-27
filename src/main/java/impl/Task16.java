package impl;

import model.Sentence;
import model.Word;

import java.util.List;

public class Task16 {

    public Sentence replaceWordsWithLength(Sentence sentence, int length, Word newWord) {
        List<Word> words = sentence.getWords();
        String newCharSeq = newWord.getCharSequence();

        for (Word word : words) {
            if (word.getCharSequence().length() == length) {
                word.setCharSequence(newCharSeq);
            }
        }

        return sentence;
    }
}
