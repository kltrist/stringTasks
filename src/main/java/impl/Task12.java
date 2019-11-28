package impl;

import model.Sentence;
import model.Text;
import model.Word;

public class Task12 {

    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public Text removeWordsStartsWithConsonantWithLength(Text text, int length) {

        for (Sentence sentence : text.getSentences()) {
            for (Word word : sentence.getWords()) {
                String charSequence = word.getCharSequence();
                if (charSequence.length() != length || isVowel(charSequence.charAt(0))) {
                    sentence.removeWord(word);
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
