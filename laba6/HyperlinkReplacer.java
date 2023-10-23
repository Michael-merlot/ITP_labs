import java.util.regex.*;

public class HyperlinkReplacer {
    public static void main(String[] args) {
        String text = "Visit our website at http://example.com or follow us on https://twitter.com/example.";

        // Регулярное выражение для поиска URL-адресов
        String regex = "https?://[\\w.-]+(?:/\\S*)?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            // Заменяем найденный URL на гиперссылку
            matcher.appendReplacement(result, "<a href=\"" + matcher.group() + "\">" + matcher.group() + "</a>");
        }

        // Добавляем оставшуюся часть текста
        matcher.appendTail(result);

        System.out.println(result.toString());
    }
}
// Регулярное выражение для поиска URL-адресов: https?://[\\w.-]+(?:/\\S*)?
//
//- https?: http или https
//- ://: разделитель протокола и домена
//- [\\w.-]+: доменное имя (состоит из букв, цифр, точек и дефисов)
//- (?:/\\S*)?: опциональный путь и параметры URL (без пробелов)
//Создание объектов Pattern и Matcher: Компилируем регулярное выражение и создаём объект Matcher для поиска совпадений в тексте.
//Использование StringBuffer для хранения результата: StringBuffer используется для эффективного изменения строк.
//Цикл while (matcher.find()): Находит каждый URL в тексте и заменяет его на гиперссылку с помощью appendReplacement.
//matcher.appendTail(result): Добавляет оставшуюся часть текста после последнего совпадения.