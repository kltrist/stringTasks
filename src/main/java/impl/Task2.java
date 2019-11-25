package impl;

import model.Sentence;
import model.Text;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

    public List<Sentence> getAllSentencesByWordNumberAsc(Text text) {
        return text.getSentences().stream()
                .sorted(Comparator.comparingLong(o -> o.getWords().size()))
                .collect(Collectors.toList());
    }
}
