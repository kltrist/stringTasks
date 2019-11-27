
import impl.Task1;
import impl.Task10;
import impl.Task11;
import impl.Task15;
import impl.Task15;
import impl.Task16;
import impl.Task2;
import impl.Task3;
import impl.Task5;
import impl.Task6;
import impl.Task7;
import impl.Task8;
import impl.Task9;
import impl.comparator.ByLetterMeetingsComparator;
import impl.comparator.FirstConsonantComparator;
import model.Sentence;
import model.Text;
import model.Word;
import org.junit.Assert;
import org.junit.Test;
import util.CustomTokenizer;
import util.Printer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskImplTest {


    private static Text getExampleText() {
        String stringDoc = "История Java восходит к 1991 году, когда группа инженеров из компании " +
                "Sun под руководством Патрика Нотона и члена Совета директоров Джеймса Гослинга занялась разработкой небольшого языка, " +
                "который можно было бы использовать для программирования бытовых устройств, например, контроллеров для переключения каналов кабельного телевидения." +
                "Поскольку такие устройства не потребляют много энергии и не имеют больших микросхем памяти, я должен был быть маленьким и генерировать очень компактные программы. " +
                "Кроме того, поскольку разные производители могут выбирать разные центральные процессоры, " +
                "было важно не завязнуть в какой-то одной архитектуре компьютеров. Проект получил кодовое название Green." +
                "Стремясь изобрести небольшой, компактный и машинонезависимый код, разработчики возродили модель, " +
                "использованную при реализации первых версий языка Pascal заре эры персональных компьютеров. " +
                "Никлаус Вирт, создатель языка Pascal, в свое время разработал машинонезависимый язык, генерирующий промежуточный код для некоей гипотетической машины. " +
                "Этот язык стал коммерческим продуктом под названием UCSD Pascal. " +
                "Такие гипотетические машины часто называются виртуальными — например, виртуальная машина языка Java, или JVM." +
                "Этот промежуточный код можно выполнять на любой машине, имеющей соответствующий интерпретатор. Инженеры, работавшие над проектом Green, " +
                "также использовали виртуальную машину, что решило их основную проблему.";

        return CustomTokenizer.tokenize(stringDoc);
    }

    private static Sentence getExampleSentence() {
        Sentence sentence = new Sentence();
        sentence.addWord(new Word("компания"));  //  4/8=0.5
        sentence.addWord(new Word("микросхема"));//  4/10=0.4
        sentence.addWord(new Word("идея"));      //  3/4=0.75
        sentence.addWord(new Word("совет"));     //  2/5=0.4
        sentence.addWord(new Word("разработка"));//  4/10=0.4
        return sentence;
    }

    //task 1
    @Test
    public void getSentencesWithSameWords() {
        Task1 task1 = new Task1();
        Text text = CustomTokenizer.tokenize("В этой строке строке повторяются слова. А в этой нет. Java is the best!!");
        List<Sentence> sentenceList = task1.getSentencesWithSameWords(text);
        Assert.assertEquals(sentenceList.size(),1);
        Assert.assertTrue(sentenceList.get(0).getWords().contains(new Word("строке")));
    }


    //task 2
    @Test
    public void getAllSentencesByWordNumberAsc() {
        Task2 taskImpl = new Task2();
        List<Sentence> sentenceList = taskImpl.getAllSentencesByWordNumberAsc(getExampleText());
        for (int i = 0; i < sentenceList.size() - 1; i++) {
            int wordCount = sentenceList.get(i).getWords().size();
            int nextWordCount = sentenceList.get(i + 1).getWords().size();
            Assert.assertTrue(wordCount <= nextWordCount);
        }
    }

    //task 3
    @Test
    public void getWordInFirstSentenceWhichNotInOthers() {
        Task3 taskImpl = new Task3();
        Text exampleText = getExampleText();
        Word uniqueWord = taskImpl.getWordInFirstSentenceWhichNotInOthers(exampleText);

        List<Sentence> sentenceList = exampleText.getSentences();
        for (int i = 1; i < sentenceList.size(); i++) {
            Assert.assertFalse(sentenceList.get(i).getWords().contains(uniqueWord));
        }
    }

    //task 5
    @Test
    public void swapFirstWordWithLastInEachSentence() {
        Task5 taskImpl = new Task5();
        Text exampleText = getExampleText();
        List<Sentence> sentences = exampleText.getSentences();
        for (Sentence sentence : sentences) {
            List<Word> words = sentence.getWords();

            Word firstWord = words.get(0);
            Word lastWord = words.get(words.size() - 1);
            int wordsCount = words.size();

            taskImpl.swapFirstWordWithLastInEachSentence(exampleText);

            Assert.assertEquals(words.get(0), lastWord);
            Assert.assertEquals(words.get(words.size() - 1), firstWord);
            Assert.assertEquals(wordsCount, words.size());
        }
    }

    //task 6
    @Test
    public void getAllWordsSortByFirstLetterAsc() {
        Task6 taskImpl = new Task6();
        Text text = getExampleText();
        List<Word> words = taskImpl.getAllWordsSortByFirstLetterAsc(text);

        for (int i = 0; i < words.size() - 1; i++) {
            char currentWordFirstLetter = words.get(i).getCharSequence().charAt(0);
            char nextWordFirstLetter = words.get(i + 1).getCharSequence().charAt(0);

            Printer.printWord(words.get(i));
            if (currentWordFirstLetter != nextWordFirstLetter)
                System.out.println();

            Assert.assertTrue(currentWordFirstLetter <= nextWordFirstLetter);
        }
    }

    //task 7
    @Test
    public void getWordsSortByVowelsFractionAsc() {
        Task7 taskImpl = new Task7();

        Text text = new Text(getExampleSentence());

        List<Word> words = taskImpl.getWordsSortByVowelsFractionAsc(text);

        Assert.assertEquals(new Word("идея"), words.get(0));
        Assert.assertEquals(new Word("компания"), words.get(1));

    }

    //task 8
    @Test
    public void getWordsStartingWithVowelsSortByFirstConsonantLetter() {
        Task8 taskImpl = new Task8();
        List<Word> words = taskImpl.getWordsStartingWithVowelsSortByFirstConsonantLetter(getExampleText());

        words.forEach(word ->
                Assert.assertFalse(FirstConsonantComparator.isConsonant(word.getCharSequence().charAt(0))));

        for (int i = 0; i < words.size() - 1; i++) {
            char currentLetter = FirstConsonantComparator.getFirstConsonant(words.get(i).getCharSequence());
            char nextLetter = FirstConsonantComparator.getFirstConsonant(words.get(i + 1).getCharSequence());
            Assert.assertTrue(currentLetter <= nextLetter);
        }
    }

    //task 9
    @Test
    public void getWordsSortByLetterCountAsc() {
        Task9 taskImpl = new Task9();

        char definedLetter = 'о';
        List<Word> words = taskImpl.getWordsSortByLetterCountAsc(getExampleText(), definedLetter);
        for (int i = 0; i < words.size() - 1; i++) {
            int currentWordLetterCount = ByLetterMeetingsComparator
                    .matchesCount(words.get(i).getCharSequence(), definedLetter);

            int nextWordLetterCount = ByLetterMeetingsComparator
                    .matchesCount(words.get(i + 1).getCharSequence(), definedLetter);

            Assert.assertTrue(currentWordLetterCount <= nextWordLetterCount);
        }
    }

    //task 10
    @Test
    public void getWordsListByFrequency() {
        Task10 taskImpl = new Task10();
        List<Map.Entry<Word, Integer>> listByFrequency = taskImpl.getWordsListByFrequency(getExampleText());
        for (int i = 0; i < listByFrequency.size() - 1; i++) {
            Assert.assertTrue(listByFrequency.get(i).getValue() >= listByFrequency.get(i + 1).getValue());
        }
    }

    @Test
    public void removeLongestWordInSentenceByLetters() {
        Task11 taskImpl = new Task11();
        Text sourceText = getExampleText();
        Text processedText = taskImpl.removeLongestWordInSentenceByLetters(getExampleText(), 'j', 'a');
        Assert.assertTrue(sourceText.getSentences().get(0).getWords().size() > processedText.getSentences().get(0).getWords().size());
    }

    //task 15
    @Test
    public void removeAllOccurrencesOfFirstLetter() {
        Task15 taskImpl = new Task15();
        Text newText = taskImpl.removeAllOccurrencesOfFirstLetter(getExampleText());

        for (Word word : newText.getAllWords()) {
            String firstLetter = String.valueOf(word.getCharSequence().charAt(0));
            Assert.assertFalse(word.getCharSequence().substring(1).contains(firstLetter));
        }

    }

    //task 16
    @Test
    public void replaceWordsWithLength() {
        Task16 taskImpl = new Task16();
        Sentence exampleSentence = getExampleSentence();

        int wordLength = 5;
        Word wordForReplace = new Word("REPLACED");

        List<Word> wordsToBeReplaced = exampleSentence.getWords().stream()
                .filter(word -> word.getCharSequence().length() == wordLength)
                .collect(Collectors.toList());

        Sentence sentence = taskImpl.replaceWordsWithLength(exampleSentence, wordLength, wordForReplace);
        String strSentence = sentence.toString();
        Assert.assertTrue(strSentence.contains(wordForReplace.getCharSequence()));

        for (Word replacedWord : wordsToBeReplaced) {
            Assert.assertEquals(replacedWord.getCharSequence(), wordForReplace.getCharSequence());
        }


    }


}
