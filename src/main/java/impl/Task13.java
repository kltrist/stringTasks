package impl;

import model.Text;
import model.Word;

import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Task13 {

    public List<Word> sortByLetterOccurrencesDesc(Text text, char character) {

        return text.getAllWords().stream()
                .sorted(comparingInt((Word word) -> (int) word.getCharSequence().chars().filter(ch -> ch == character).count()).reversed()
                        .thenComparing(word -> word.getCharSequence().charAt(0)))
                .collect(toList());

    }
}
