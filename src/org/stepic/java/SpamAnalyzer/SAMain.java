package org.stepic.java.SpamAnalyzer;

public class SAMain {

    public static void main(String[] args) { // main в ответ не печатаем, только для теста

        String[] spamKeywords = {"bad","spam"}; // Слова, относящиеся к спаму
        int commentMaxLength = 40; // Максимальная длина строки
        String s = "This not :("; // Тестируемая строка

        TextAnalyzer[] textAnalyzers = { // Массив, подаваемый на вход checkLabels()
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };

        System.out.println(checkLabels(textAnalyzers, s)); // На выходе SPAM, так как String s содержит ключевое слово "spam" из spamKeywords
    };

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer anal: analyzers) {
            Label result;
            if ((result = anal.processText(text)) != Label.OK){
                return result;
            }
        }
        return Label.OK;
    }

}

interface TextAnalyzer {
    Label processText(String text);
};

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
};

// Абстрактный класс анализатора ключевиков
abstract class KeywordAnalyzer implements TextAnalyzer {
    abstract protected String[] getKeywords(); //возвращает набор ключевых слов
    abstract protected Label getLabel(); //возвращает метку, которой необходимо пометить положительные срабатывания

    // Реализуем processText таким образом, чтобы он зависел только от getKeywords и getLabel.
    public Label processText(String text) {
        String[] keywords = getKeywords();
        for (int i = 0; i < keywords.length; i++) {
            if (text.indexOf(keywords[i]) != -1) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords;
    private Label label = Label.SPAM;

    public SpamAnalyzer(String[] keywords){
        this.keywords = keywords;
    }

    protected String[] getKeywords() {
        return keywords;
    }
    protected Label getLabel() {
        return label;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords = {":(", "=(", ":|"};
    private Label label = Label.NEGATIVE_TEXT;

    protected String[] getKeywords() {
        return keywords;
    }
    protected Label getLabel() {
        return label;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int length){
        this.maxLength = length;
    }

    public Label processText(String text) {
        return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
    }
}


