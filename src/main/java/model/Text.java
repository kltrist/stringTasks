package model;

import java.util.ArrayList;
import java.util.List;

public class Text {

    private List<Sentence> sentences;

    public Text() {
        sentences = new ArrayList<>();
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Text(Sentence sentence) {
        this.sentences = new ArrayList<>();
        sentences.add(sentence);
    }

    public void addSentence(Sentence sentence) {
        if (sentence == null)
            throw new IllegalArgumentException("You pass null sentence!");

        sentence.setId(sentences.size() + 1);
        sentences.add(sentence);
    }

    public List<Word> getAllWords() {
        List<Word> words = new ArrayList<>();
        sentences.forEach(sentence -> words.addAll(sentence.getWords()));
        return words;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sentences.forEach(sb::append);
        return sb.toString();
    }


}
