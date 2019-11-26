package impl;

import impl.comparator.FirstConsonantComparator;
import model.Text;
import model.Word;

import java.util.ArrayList;
import java.util.List;

public class Task8   {

    private static final char[] VOWELS = "aeiouуеыаоэяию".toCharArray();

    public List<Word> getWordsStartingWithVowelsSortByFirstConsonantLetter(Text text) {
        List<Word> allWords = text.getAllWords();

        List<Word> wordsStartingWithVowels = getWordsFilterByStartingWithVowels(allWords);
        wordsStartingWithVowels.sort(new FirstConsonantComparator());

        return wordsStartingWithVowels;
    }

    private List<Word> getWordsFilterByStartingWithVowels(List<Word> words) {
        List<Word> wordsStartingWithVowels = new ArrayList<>();

        for (char letter : VOWELS) {
            String strLetter = String.valueOf(letter);

            for (Word word : words) {
                if (word.getCharSequence().startsWith(strLetter)) {
                    wordsStartingWithVowels.add(word);
                }
            }

        }
        return wordsStartingWithVowels;
    }


}
