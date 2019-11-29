package impl;

import model.Sentence;
import model.Text;
import model.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Task3 {
    final static Logger logger = LoggerFactory.getLogger(Task3.class);

    public Word getWordInFirstSentenceWhichNotInOthers(Text text) {
        logger.info("Task 3 :");
        logger.info(text.toString());
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
        logger.info("Result: " + uniqueWord);
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
