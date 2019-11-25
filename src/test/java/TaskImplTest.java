import impl.Task2;
import impl.Task3;
import model.Sentence;
import model.Text;
import model.Word;
import org.junit.Assert;
import org.junit.Test;
import util.CustomTokenizer;

import java.util.List;

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

    private Text text = getExampleText();


    //task 2
    @Test
    public void getAllSentencesByWordNumberAsc() {
        Task2 taskImpl = new Task2();
        List<Sentence> sentenceList = taskImpl.getAllSentencesByWordNumberAsc(text);
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
        Word uniqueWord = taskImpl.getWordInFirstSentenceWhichNotInOthers(text);

        List<Sentence> sentenceList = text.getSentences();
        for (int i = 1; i < sentenceList.size(); i++) {
            Assert.assertFalse(sentenceList.get(i).getWords().contains(uniqueWord));
        }
    }


}
