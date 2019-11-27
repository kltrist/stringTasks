package impl;

import model.Text;
import model.Word;

public class Task15 {

    public Text removeAllOccurrencesOfFirstLetter(Text text) {
        for (Word word : text.getAllWords()) {
            String charSequence = word.getCharSequence();
            String firstLetter = String.valueOf(charSequence.charAt(0));

            String newCharSequence = charSequence.charAt(0) + charSequence.substring(1).replace(firstLetter, "");
            word.setCharSequence(newCharSequence);
        }

        return text;
    }

}
