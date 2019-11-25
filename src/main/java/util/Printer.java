package util;

import model.Sentence;
import model.Text;
import model.Word;

import java.util.List;

public class Printer {


    public static void printWord(Word word) {
        System.out.println(word.getCharSequence());
    }

    public static void printSentence(Sentence sentence) {
        System.out.println(sentence.toString());
    }

    public static void printSentences(List<Sentence> sentenceList) {
        sentenceList.forEach(sentence -> System.out.println(sentence.toString()));
    }

    public static void printText(Text text) {
        System.out.println(text.toString());
    }


}
