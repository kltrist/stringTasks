package impl;

import model.Text;
import model.Word;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task6 {

    public List<Word> getAllWordsSortByFirstLetterAsc(Text text) {
        return text.getAllWords().stream()
                .sorted(Comparator.comparing(w -> w.getCharSequence().substring(0, 1)))
                .collect(Collectors.toList());

    }

}
