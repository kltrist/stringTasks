package impl;

import model.Sentence;
import model.Text;
import model.Word;

import java.util.Collections;
import java.util.List;

public class Task5 {

    public void swapFirstWordWithLastInEachSentence(Text text) {
        for (Sentence sentence : text.getSentences()) {
            List<Word> words = sentence.getWords();
            Collections.swap(words, 0, words.size()-1);
        }
    }


}
