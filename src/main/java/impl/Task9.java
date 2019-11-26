package impl;

import impl.comparator.ByLetterMeetingsComparator;
import model.Text;
import model.Word;

import java.util.List;

public class Task9 {

    public List<Word> getWordsSortByLetterCountAsc(Text text, char letter) {
        List<Word> words = text.getAllWords();
        words.sort(new ByLetterMeetingsComparator(letter));

        return words;
    }
}
