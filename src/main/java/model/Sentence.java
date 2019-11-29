package model;

import util.StringUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Sentence {

    private long id;

    private List<Word> words;

    public Sentence() {
        words = new ArrayList<>();
    }

    public Sentence(List<Word> words) {
        this.words = words;
    }

    public void addWord(Word word) {
        if (word == null)
            throw new IllegalArgumentException("You pass null word!");

        word.setId(words.size() + 1L);
        words.add(word);
    }

    public void removeWord(Word word) {
        if (word.getId() == null)
            throw new IllegalArgumentException("Word ID is undefended!");

        words.removeIf(value -> value.getId().equals(word.getId()));
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return id == sentence.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String firstWord = StringUtil.firstLetterToUpperCase(words.get(0).getCharSequence());
        sb
                .append(" ")
                .append(firstWord);

        for (int i = 1; i < words.size(); i++) {
            sb.append(" ").append(words.get(i));
        }
        sb.append(".");

        return sb.toString();
    }
}
