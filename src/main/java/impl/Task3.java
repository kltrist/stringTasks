package impl;

import model.Sentence;
import model.Text;
import model.Word;

import java.util.List;

public class Task3 {

    public Word getWordInFirstSentenceWhichNotInOthers(Text text) {
        List<Sentence> sentences = text.getSentences();
        Sentence firstSentence = sentences.get(0);
        List<Word> wordsOfFirstSentence = firstSentence.getWords();
        Word uniqueWord = null;

        for (Word word : wordsOfFirstSentence) {
            if (!isSentencesContainWord(sentences.subList(1, sentences.size()), word)) {
                uniqueWord = word;
                break;
            }
        }
        return uniqueWord;
    }

    private boolean isSentencesContainWord(List<Sentence> sentenceList, Word word) {
        boolean isContain = false;
        for (Sentence sentence : sentenceList) {
            if (sentence.getWords().contains(word)) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }

}
