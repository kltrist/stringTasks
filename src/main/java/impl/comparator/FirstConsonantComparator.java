package impl.comparator;

import model.Word;

import java.util.Comparator;

public class FirstConsonantComparator implements Comparator<Word> {
    private final static String CONSONANTS = "BCDFGHJKLMNPQRSTVXZWYЙЦКНГШЩЗХЪФВПРЛДЖЧСМТЬБ";

    public static boolean isConsonant(Character c) {
        return CONSONANTS.contains(String.valueOf(c));
    }

    public static Character getFirstConsonant(String string) {
        for (int i = 0; i < string.length(); ++i)
            if (isConsonant(string.charAt(i)))
                return string.charAt(i);
        return Character.MIN_VALUE;
    }

    @Override
    public int compare(Word a, Word b) {
        Character consonantA = getFirstConsonant(a.getCharSequence());
        Character consonantB = getFirstConsonant(b.getCharSequence());
        return consonantA.compareTo(consonantB);
    }
}
