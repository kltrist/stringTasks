package impl.comparator;

import model.Word;

import java.util.Comparator;


public class ByLetterMeetingsComparator implements Comparator<Word> {
    private char letter;

    public ByLetterMeetingsComparator(char l) {
        letter = l;
    }

    public static int matchesCount(String s,char letter) {
        int found = 0;

        for (char c : s.toCharArray())
            if (letter == c)
                ++found;

        return found;
    }

    public int compare(Word a, Word b) {
        String charSequenceA = a.getCharSequence();
        String charSequenceB = b.getCharSequence();
        int diff = matchesCount(charSequenceA,letter) - matchesCount(charSequenceB,letter);
        return (diff != 0) ? diff : charSequenceA.compareTo(charSequenceB);
    }
}