package impl;

import model.Sentence;
import model.Text;
import model.Word;

public class Task11 {

    public Text removeLongestWordInSentenceByLetters(Text text, Character firstLetter, Character lastLetter) {
        for (Sentence sentence: text.getSentences()) {
            Word longestWord = getLongestWord(sentence, firstLetter, lastLetter);
            if(longestWord != null) {
                sentence.removeWord(longestWord);
            }
        }
        return text;
    }

    private Word getLongestWord(Sentence sentence, Character firstLetter, Character lastLetter) {
        Word longestWord = null;
        for (Word word: sentence.getWords()) {
            if(doesLettersSurroundsTheWord(word, firstLetter, lastLetter)
                    &&  (longestWord == null || longestWord.getCharSequence().length() < word.getCharSequence().length())){
             longestWord = word;
         }
        }
        return longestWord;
    }

    private boolean doesLettersSurroundsTheWord(Word word, Character firstLetter, Character lastLetter) {
        return word.getCharSequence().startsWith(firstLetter.toString()) && word.getCharSequence().endsWith(lastLetter.toString());
    }
}
