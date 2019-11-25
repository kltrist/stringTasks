package model;

import util.StringUtil;

import java.util.Objects;

public class Word {

    private long id;

    private String charSequence;

    private Sentence parent;

    public Word(String charSequence) {
        this.charSequence = charSequence.toLowerCase();
    }

    public long getId() {
        return id;
    }

    public Sentence getParent() {
        return parent;
    }

    public void setParent(Sentence parent) {
        this.parent = parent;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCharSequence() {
        return charSequence;
    }

    public void setCharSequence(String charSequence) {
        this.charSequence = charSequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(charSequence, word.charSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charSequence);
    }

    @Override
    public String toString() {
        return charSequence;
    }
}
