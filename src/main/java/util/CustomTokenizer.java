package util;

import model.Sentence;
import model.Text;
import model.Word;

import java.util.StringTokenizer;

public class CustomTokenizer {

    private static final String WORDS_DELIMITERS = "\\[ ,:-]";

    public static Text tokenize(String doc) {
        doc = getWithoutExcessSpaces(doc);
        Text text = new Text();

        //sentences
        for (String strSentence : doc.split("[.?!;]")) {
            Sentence sentence = new Sentence();

            //words in sentence
            StringTokenizer tokenizer = new StringTokenizer(strSentence, WORDS_DELIMITERS);
            while (tokenizer.hasMoreTokens()) {
                sentence.addWord(new Word(tokenizer.nextToken()));
            }
            text.addSentence(sentence);
        }
        return text;
    }

    private static String getWithoutExcessSpaces(String doc) {
        return doc.trim()
                .replaceAll("\\s{2}", "\\s");
    }

}
