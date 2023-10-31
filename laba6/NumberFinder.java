import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99, but there are also 20 items.";
        // Регулярное выражение для поиска всех чисел (целых и с плавающей точкой)
        Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d+)?\\b");
        Matcher matcher = pattern.matcher(text);
// создаём объект Pattern, компилируя регулярное выражение. регулярное выражение будет
// использоваться для поиска всех чисел (целых и с плавающей точкой) в тексте

        while (matcher.find()) { // Метод find() в классе Matcher ищет следующее совпадение в тексте.
            System.out.println(matcher.group());
        } // метод group() возвращает это совпадение как строку.
    }
}

// \\b — указывает на границу слова, чтобы избежать срабатывания на числах внутри слов.
// \\d+ — одна или более цифр.
// (\\.\\d+)? — опциональная десятичная точка, за которой следует одна или более цифр.