package impl;

import model.Sentence;
import model.Text;
import model.Word;

import java.util.Iterator;

public class Task12 {

    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public Text removeWordsStartsWithConsonantWithLength(Text text, int length) {

        for (Sentence sentence : text.getSentences()) {
            for (Iterator<Word> it = sentence.getWords().iterator(); it.hasNext(); ) {
                Word word = it.next();
                String charSequence = word.getCharSequence();
                if (charSequence.length() == length && !isVowel(charSequence.charAt(0))) {
                    it.remove();
                }
            }
        }
        return text;
    }


    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);

        for (char d : vowels) {
            if (c == d)
                return true;
        }
        return false;
    }


}
