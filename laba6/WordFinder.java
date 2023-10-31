import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        String text = "Apple, apricot, and banana are fruits. Avocado is also a fruit.";
        char startingLetter = 'A';  // на букву, с которой должны начинаться слова

        // Регулярное выражение для поиска слов, начинающихся с заданной буквы
        String regex = "\\b[" + startingLetter + startingLetter + "]\\w*\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
// Инициализация переменных text и startingLetter: В этих переменных хранятся текст для поиска и начальная буква для слов.
//Регулярное выражение для поиска слов: \\b[" + startingLetter + "]\\w*\\b
//- \\b: граница слова, чтобы избежать срабатывания на словах, где заданная буква находится не в начале.
//- [" + startingLetter + "]: заданная начальная буква.
//- \\w*: ноль или больше букв или цифр, следующих за начальной буквой.
//- \\b: другая граница слова для завершения поиска.