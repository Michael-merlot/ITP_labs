import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.TreeMap;
import java.util.Arrays;

public class laba4_java {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abracadabra"));  // Output: "abrcd"
        System.out.println(nonRepeatable("paparazzi"));    // Output: "parzi"
        System.out.println("---");

        System.out.println(generateBrackets(1));  // Output: ["()"]
        System.out.println(generateBrackets(2));  // Output: ["(())", "()()"]
        System.out.println(generateBrackets(3));  // Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
        System.out.println("---");

        System.out.println(binarySystem(3));  // Output: ["010", "011", "101", "110", "111"]
        System.out.println(binarySystem(4));  // Output: ["0101", "0110", "0111", "1010", "1011", "1101", "1110", "1111"]
        System.out.println("---");

        System.out.println(alphabeticRow("abcdjuwx"));  // Output: "abcd"
        System.out.println(alphabeticRow("klmabzyxw")); // Output: "zyxw"
        System.out.println("---");

        System.out.println(compressAndSort("aaabbcdd"));  // Output: "c1b2d2a3"
        System.out.println(compressAndSort("vvvvaajaaaaa")); // Output: "j1a2v4a5"
        System.out.println("---");

        System.out.println(convertToNum("eight"));  // Output: 8
        System.out.println(convertToNum("five hundred sixty seven"));  // Output: 567
        System.out.println(convertToNum("thirty one"));  // Output: 31
        System.out.println("---");

        System.out.println(uniqueSubstring("123412324"));  // Output: "1234"
        System.out.println(uniqueSubstring("111111"));     // Output: "1"
        System.out.println(uniqueSubstring("77897898"));   // Output: "789"
        System.out.println("---");

        int[][] matrix1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(shortestWay(matrix1));  // Output: 7

        int[][] matrix2 = {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        };
        System.out.println(shortestWay(matrix2));  // Output: 21
        System.out.println("---");

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));  // Output: " One ring to rule them all"
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));  // Output: " With great power comes great responsibility"
        System.out.println("---");

        System.out.println(switchNums(519, 723));  // Output: 953
        System.out.println(switchNums(491, 3912)); // Output: 9942
        System.out.println(switchNums(6274, 71259)); // Output: 77659
        System.out.println("---");
    }

// Задание 1 Напишите рекурсивную функцию, которая принимает строку и удаляет из неё повторяющиеся символы.
// Функция должна вернуть строку, в которой каждый символ встречается только один раз.
    public static String nonRepeatable(String str) {
        return nonRepeatableHelper(str, new HashSet<>(), 0);
    }// Здесь метод вызывает вспомогательный метод nonRepeatableHelper,
    // передавая ему исходную строку, новый пустой HashSet и начальный индекс 0.

    private static String nonRepeatableHelper(String str, HashSet<Character> seen, int index) {
        if (index >= str.length()) {
            return ""; // Если индекс больше или равен длине строки, метод возвращает пустую строку.
        }

        char ch = str.charAt(index); // Извлекаем символ из строки по текущему индексу.
        if (seen.contains(ch)) {
            return nonRepeatableHelper(str, seen, index + 1);
        }// Если символ уже присутствует в наборе seen, рекурсивно вызываем метод, увеличив индекс на 1.

        seen.add(ch); // Добавляем символ в набор seen.
        return ch + nonRepeatableHelper(str, seen, index + 1);
    }// Возвращаем текущий символ, добавленный к результату рекурсивного вызова метода с увеличенным индексом.

// Задание 2 Напишите функцию, которая генерирует все возможные правильные комбинации пар скобок для заданного числа n.
    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>(); // Инициализация пустого списка result для хранения результирующих комбинаций.
        generate("", 0, 0, n, result); // Вызов вспомогательного метода generate с начальными параметрами.
        return result;
    }

    private static void generate(String cur, int open, int close, int max, List<String> res) {
        if (cur.length() == max * 2) { // Если текущая строка достигла максимальной длины 2*n
            res.add(cur); // добавляем её в результат и возвращаемся из рекурсии.
            return;
        }
        if (open < max) generate(cur + "(", open + 1, close, max, res);
        if (close < open) generate(cur + ")", open, close + 1, max, res);
    } // Если количество открытых скобок меньше n добавляем открывающую скобку и рекурсивно вызываем метод.
// Если количество закрытых скобок меньше количества открытых, добавляем закрывающую скобку и рекурсивно вызываем метод.

// Задание 3  Напишите функцию, которая генерирует все возможные бинарные комбинации длины n,
// в которых не может быть соседствующих нулей.
    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>(); // Инициализация пустого списка result для хранения результирующих комбинаций.
        generateBinary("", n, result);
        return result;
    }

    private static void generateBinary(String current, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return; // Если текущая строка достигла заданной длины n добавляем её в результат и возвращаемся из рекурсии.
        }

        if (current.endsWith("0")) { // Если текущая строка заканчивается на "0", добавляем "1" и рекурсивно вызываем метод.
            generateBinary(current + "1", n, result);
        } else { // В противном случае (если строка заканчивается на "1" или пустая),
            // добавляем и "0", и "1", и рекурсивно вызываем метод для обоих вариантов.
            generateBinary(current + "0", n, result);
            generateBinary(current + "1", n, result);
        }
    }

// Задание 4 Реализуйте функцию, которая принимает строку и возвращает длину самого длинного последовательного ряда в этом массиве.
// Последовательный ряд – это список соседних элементов, идущих подряд в алфавитном порядке,
// который может быть как увеличивающимся, так и уменьшающимся/соседним по алфавиту с предыдущим символом.
    public static String alphabeticRow(String str) {
        String longest = "", current = str.substring(0, 1);
// Инициализация двух строковых переменных: longest для хранения самой длинной подстроки и current для хранения текущей подстроки.
// current инициализируется первым символом входной строки.
        for (int i = 1; i < str.length(); i++) { // Цикл, который идёт с 1-го символа до последнего в строке.
            if (Math.abs(str.charAt(i) - str.charAt(i - 1)) == 1) { //является ли текущий символ соседним по алфавиту с предыдущим символом.
            current += str.charAt(i); //  Если условие выполнено, добавляем текущий символ к current.
            } else {
                longest = current.length() > longest.length() ? current : longest;
                current = String.valueOf(str.charAt(i));
            } // longest;: Сравниваем длину current и longest и сохраняем более длинную строку в longest.
        }

        return current.length() > longest.length() ? current : longest;
    } // В конце метода сравниваем current и longest ещё раз и возвращаем более длинную строку.

// Задание 5 Напишите функцию, которая принимает строку и подсчитывает количество идущих подряд символов,
// заменяя соответствующим числом повторяющиеся символы.
// Отсортируйте строку по возрастанию длины буквенного паттерна.
// (последним или отличается от предыдущего)
    public static String compressAndSort(String str) {
        StringBuilder result = new StringBuilder(); // для формирования результирующей строки.
        ArrayList<String> segments = new ArrayList<>(); // Список для хранения сжатых сегментов строки.

        int count = 1; // подсчета количества повторяющихся символов.
        for (int i = 1; i <= str.length(); i++) { // проходит по всей строке.
            if (i == str.length() || str.charAt(i) != str.charAt(i - 1)) { // является ли текущий символ последним или отличается от предыдущего.
                segments.add(str.charAt(i - 1) + String.valueOf(count)); // Добавляем сжатый сегмент в список.
                count = 1; // Сбрасываем счетчик.
            } else {
                count++; // Если текущий символ совпадает с предыдущим, увеличиваем счетчик.
            }
        }

        Collections.sort(segments, Comparator.comparingInt(String::length));
        // Сортируем сегменты по их длине.
        for (String segment : segments) {
            result.append(segment);
        } // Добавляем отсортированные сегменты в результирующую строку.

        return result.toString();
    }

// Задание 6 Напишите функцию, принимающую положительное целое число в строковом формате,
// не превышающее 1000, и возвращающую его целочисленное представление.
    public static int convertToNum(String str) {
        String[] words = str.split(" "); // Разбиение входной строки на слова.
        int result = 0, current = 0; // Инициализация переменных result и current для хранения результата и текущего значения.

        HashMap<String, Integer> map = new HashMap<>();
        String[] keys = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred", "thousand"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100, 1000};

        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }

        for (String word : words) { // по всем словам в входной строке.
            int num = map.get(word); // числового значения текущего слова.
            if (num >= 100) { // является ли текущее число "сотней" или "тысячей".
                current = (current == 0 ? 1 : current) * num;
                if (num == 1000) {
                    result += current;
                    current = 0;
                } //  Если текущее число 1000, добавляем current к result и сбрасываем current
            } else {
                current += num;
            } // добавляем текущее число к current.
        }
        return result + current;
    }

// Задание 7 ⦁	Напишите функцию, принимающую строку цифр,
// выполняющую поиск подстроки максимальной длины с уникальными элементами.
// Если найдено несколько подстрок одинаковой длины, верните первую.
    public static String uniqueSubstring(String str) {
        int start = 0, end = 0, maxLength = 0; // для хранения начала подстроки, конца подстроки и максимальной длины подстроки
        String longestSubstring = ""; // хранения самой длинной подстроки с уникальными элементами.
        int[] charIndex = new int[256]; //  Массив для хранения последних индексов каждого символа в строке.

        while (end < str.length()) { // проходит по всей строке.
            if (charIndex[str.charAt(end)] > start) { // встречался ли текущий символ ранее в подстроке.
                start = charIndex[str.charAt(end)];
            } // Если да, обновляем начало подстроки.
            if (end - start > maxLength) { // является ли текущая подстрока самой длинной.
                maxLength = end - start;
                longestSubstring = str.substring(start, end + 1); // Если да, сохраняем её.
            }
            charIndex[str.charAt(end)] = end + 1; // Обновляем последний индекс текущего символа.
            end++; // Переходим к следующему символу.
        }
        return longestSubstring;
    }

// Задание 8	Напишите функцию поисковик наименьшего матричного пути.
// На вход поступает двумерный массив, размера n x n,
// ваша задача найти путь с минимальной суммой чисел, передвигаясь только вправо или вниз.

    public static int shortestWay(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length; // Определение количества строк и столбцов в матрице.
        int[][] dp = new int[rows][cols]; // Инициализация двумерного массива dp для динамического программирования.

        dp[0][0] = matrix[0][0]; // Инициализация начального элемента dp.

        // Инициализируем первую строку и первый столбец
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        // Заполним остальную часть массива dp
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        } // Двойной цикл для заполнения остальных элементов массива dp.
        // В каждой ячейке хранится минимальная сумма для пути от начала до этой ячейки.

        return dp[rows - 1][cols - 1]; //  Возвращаем значение в последней ячейке,
        // которое является минимальной суммой для пути от начала до конца.
    }

// Задание 9 ⦁	Создайте функцию, принимающую строку, содержащую числа внутри слов.
// Эти числа представляют расположение слова для новой строящейся строки.

    public static String numericOrder(String str) {
        String[] words = str.split(" "); // Разбиение входной строки на слова.
        TreeMap<Integer, String> sortedWords = new TreeMap<>(); // Использование TreeMap для автоматической сортировки слов по числам.

        Pattern pattern = Pattern.compile("\\d+"); // Регулярное выражение для поиска чисел в словах.

        for (String word : words) { // по всем словам в строке.
            Matcher matcher = pattern.matcher(word); // Поиск числа в текущем слове.
            if (matcher.find()) {
                int number = Integer.parseInt(matcher.group()); // Конвертируем найденное число в int.
                sortedWords.put(number, word.replaceAll("\\d+", ""));
            } // Добавляем слово (без числа) в TreeMap с ключом, равным найденному числу.
        }

        StringBuilder result = new StringBuilder(); // для формирования результирующей строки.
        for (String word : sortedWords.values()) { // Цикл по отсортированным словам.
            result.append(" ").append(word);
        } // Добавление каждого слова в результирующую строку с пробелом.

        return result.toString();
    }

// Задание 10 ⦁	Напишите функцию, принимающую два числа,
// которая делает второе число максимально возможным за счет замены своих элементов элементами первого числа.
// Брать цифру можно только один раз.

    public static int switchNums(int num1, int num2) {
        char[] digits1 = Integer.toString(num1).toCharArray(); // Преобразование первого числа в массив символов.
        char[] digits2 = Integer.toString(num2).toCharArray(); // Преобразование второго числа в массив символов.

        Arrays.sort(digits1); // Сортировка цифр первого числа.

        int index1 = digits1.length - 1; // индекса для первого массива символов, начиная с последнего элемента.

        for (int index2 = 0; index2 < digits2.length; index2++) {
            while (index1 >= 0 && digits1[index1] <= digits2[index2]) { // Поиск в первом числе цифры, большей, чем текущая цифра во втором числе.
                index1--; // Уменьшаем индекс для первого массива символов.
            }

            if (index1 >= 0) { // Если такая цифра найдена, то:
                digits2[index2] = digits1[index1]; // Заменяем цифру во втором числе.
                index1--; // Уменьшаем индекс для первого массива символов.
            }
        }

        return Integer.parseInt(new String(digits2)); // Преобразуем получившийся массив символов обратно в число и возвращаем его.
    }
}
