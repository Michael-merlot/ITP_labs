import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
import java.util.Stack;
import java.util.Map;
public class laba6_java {
    public static void main(String[] args) {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println("---");

        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
        System.out.println("---");

        System.out.println(nicoCipher("myworldevolvesinhers", "tesh")); // "yowmledrovlvsnieesrh"
        System.out.println(nicoCipher("andiloveherso", "tesha")); // "lnidaevheo s or"
        System.out.println(nicoCipher("mubashirhassan", "crazy")); // "bmusarhiahass n"
        System.out.println(nicoCipher("edabitisamazing", "matt")); // "deabtiismaaznig "
        System.out.println(nicoCipher("iloveher", "612345")); // "lovehir    e"
        System.out.println("---");

        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45))); // [9, 5]
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45))); // [3, 15]
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1,  2, -1,  4,  5,  6,  10, 7}, 20))); // [4, 5]
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10))); // [2, 5]
        System.out.println(java.util.Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15))); // []
        System.out.println("---");

        System.out.println(java.util.Arrays.toString(isExact(6)));     // [6, 3]
        System.out.println(java.util.Arrays.toString(isExact(24)));    // [24, 4]
        System.out.println(java.util.Arrays.toString(isExact(125)));   // []
        System.out.println(java.util.Arrays.toString(isExact(720)));   // [720, 6]
        System.out.println(java.util.Arrays.toString(isExact(1024)));  // []
        System.out.println(java.util.Arrays.toString(isExact(40320))); // [40320, 8]
        System.out.println("---");

        System.out.println(fractions("0.(6)"));        // "2/3"
        System.out.println(fractions("1.(1)"));        // "10/9"
        System.out.println(fractions("3.(142857)"));   // "22/7"
        System.out.println(fractions("0.19(2367)"));   // "5343/27775"
        System.out.println(fractions("0.1097(3)"));    // "823/7500"
        System.out.println("---");

        System.out.println(pilish_string("33314444")); // "333 1 4444"
        System.out.println(pilish_string("TOP")); // "TOP"
        System.out.println(pilish_string("X")); // "XXX"
        System.out.println(pilish_string("")); // ""
        System.out.println("---");

        System.out.println(evaluateExpression("3 + 5 * (2 - 6)")); // -17
        System.out.println(evaluateExpression("6 - 18 / (4 - 1)")); // 0
        System.out.println(evaluateExpression("6 / 0")); // Error: Cannot divide by zero
        System.out.println("---");

        System.out.println(isValid("aabbcd")); // "NO"
        System.out.println(isValid("aabbccddeefghi")); // "NO"
        System.out.println(isValid("abcdefghhgfedecba")); // "YES"
        System.out.println("---");

        System.out.println(findLCS("abcd", "bd")); // "bd"
        System.out.println(findLCS("aggtab", "gxtxamb")); // "gtab"
        System.out.println("---");


    }
    // Задание 1⦁	Создайте функцию, которая принимает две строки. Первая строка содержит предложение, содержащее буквы второй строки в последовательной последовательности,
    // но в другом порядке. Скрытая анаграмма должна содержать все буквы, включая дубликаты, из второй строки в любом порядке и не должна содержать никаких других букв алфавита.

    public static String hiddenAnagram(String text, String anagram) {
        String cleanedText = text.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Эти две строки удаляют все символы, кроме букв алфавита
        String cleanedAnagram = anagram.replaceAll("[^a-zA-Z]", "").toLowerCase(); // из text и anagram соответственно и приводят их к нижнему регистру.

        HashMap<Character, Integer> anagramMap = new HashMap<>(); // Создается HashMap для хранения количества каждого символа в анаграмме.
        for (char c : cleanedAnagram.toCharArray()) {
            anagramMap.put(c, anagramMap.getOrDefault(c, 0) + 1);
        } // Этот цикл перебирает каждый символ в cleanedAnagram и обновляет anagramMap, увеличивая счетчик для каждого символа.

        int windowStart = 0;
        int lettersToMatch = cleanedAnagram.length(); // Здесь инициализируются переменные для управления "окном" поиска в cleanedText и отслеживания количества оставшихся совпадающих букв.
        for (int windowEnd = 0; windowEnd < cleanedText.length(); windowEnd++) { // Начинается цикл, который перемещает "окно" по cleanedText.
            char endChar = cleanedText.charAt(windowEnd); // Извлекается текущий символ в конце "окна".
            if (anagramMap.containsKey(endChar)) {
                anagramMap.put(endChar, anagramMap.get(endChar) - 1);
                if (anagramMap.get(endChar) >= 0) {
                    lettersToMatch--;
                } // // Если символ присутствует в anagramMap, обновляется соответствующий счетчик и lettersToMatch.
            }

            if (lettersToMatch == 0) {
                return cleanedText.substring(windowStart, windowEnd + 1);
            } // Если все буквы анаграммы найдены в текущем "окне", возвращается подстрока.

            if (windowEnd >= cleanedAnagram.length() - 1) {
                char startChar = cleanedText.charAt(windowStart++);
                if (anagramMap.containsKey(startChar)) {
                    if (anagramMap.get(startChar) >= 0) {
                        lettersToMatch++;
                    } // После достижения определенной длины "окна", начинается процесс уменьшения "окна" с начальной стороны.
                    anagramMap.put(startChar, anagramMap.get(startChar) + 1);
                }
            }
        }

        return "notfound"; // Если подходящая анаграмма не найдена, возвращается строка "notfound".
    }
    // Задание 2⦁	Напишите функцию, которая возвращает массив строк,
    // заполненных из срезов символов n-длины данного слова (срез за другим, в то время как n-длина применяется к слову).
    public static List<String> collect(String s, int n) {
        if (s.length() < n) {
            return new ArrayList<>();
        } // Если длина входной строки меньше n, функция возвращает пустой список.

        List<String> slices = collect(s.substring(n), n); // Рекурсивно вызывается функция collect с оставшейся частью строки, начиная с позиции n. Это делит строку на срезы длиной n.
        slices.add(s.substring(0, n)); // К списку slices добавляется первый срез строки длиной n.
        if (slices.size() == 1) { // Только в конце сортируем, чтобы уменьшить количество операций
            Collections.sort(slices); // Если в списке только один элемент, то происходит его сортировка.
        }
        return slices; // Функция возвращает список срезов.
    }
    // Задание 3⦁	В шифре Nico кодирование осуществляется путем создания цифрового ключа и
    // присвоения каждой буквенной позиции сообщения с помощью предоставленного ключа.
    public static String nicoCipher(String message, String key) {
        // Подготовка списка для сопоставления символов ключа с их индексами
        List<Pair> keyIndexPairs = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) { // Создается список keyIndexPairs, содержащий пары символов ключа и их индексов. Это необходимо для упорядочивания символов ключа.
            keyIndexPairs.add(new Pair(key.charAt(i), i));
        }

        Collections.sort(keyIndexPairs); // Сортировка пар по символам ключа.

        while (message.length() % key.length() != 0) {
            message += " "; // Дополнение сообщения пробелами до тех пор, пока его длина не станет кратной длине ключа.
        }

        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < message.length(); i += key.length()) { // Инициализация StringBuilder для построения зашифрованного сообщения. Цикл обрабатывает сообщение блоками, длина каждого из которых равна длине ключа.
            char[] block = new char[key.length()];
            for (int j = 0; j < key.length(); j++) {
                int originalIndex = keyIndexPairs.get(j).index;
                block[j] = message.charAt(i + originalIndex); // Создание блока символов, где каждый символ выбирается из исходного сообщения согласно упорядоченному индексу ключа.
            }
            for (char c : block) {
                encoded.append(c); // Добавление переставленных символов в encoded.
            }
        }

        return encoded.toString(); // Возвращение зашифрованной строки.
    }

// Вспомогательный класс Pair, используемый для хранения пар символов и их индексов в ключе, а также для их сравнения и сортировки.
    static class Pair implements Comparable<Pair> { // Статический класс может быть использован без создания экземпляра внешнего класса.
        char character; // Pair реализует интерфейс Comparable с типом Pair. Это означает, что объекты Pair могут сравниваться друг с другом, что полезно для сортировки.
        int index;
// char character: поле для хранения символа.
//int index: поле для хранения целочисленного индекса.
        Pair(char character, int index) {
            this.character = character;
            this.index = index;
        } // this.character = character;: присваивает переданный символ character полю character объекта.
// this.index = index;: присваивает переданный индекс index полю index объекта.

        @Override // Это аннотация, указывающая, что данный метод переопределяет метод из суперкласса или интерфейса.
        public int compareTo(Pair other) { // Реализация метода compareTo из интерфейса Comparable.
            // Этот метод используется для сравнения текущего объекта Pair с другим объектом Pair.
            return Character.compare(this.character, other.character);
        } // Возвращает результат сравнения символов двух объектов Pair. Если символ текущего объекта (this.character) меньше символа другого объекта (other.character), метод вернет отрицательное число.
    // Если они равны, метод вернет ноль. Если символ текущего объекта больше, метод вернет положительное число.
    }
    // Задание 4⦁	Создайте метод, который принимает массив arr и число n и
    // возвращает массив из двух целых чисел из arr, произведение которых равно числу n следующего вида:
    public static int[] twoProduct(int[] arr, int n) {
        Set<Integer> set = new HashSet<>(); // Создается множество set, которое будет использоваться для хранения элементов массива. HashSet позволяет быстро проверить, содержится ли элемент в множестве.
        for (int value : arr) { // Начинается цикл, который перебирает каждый элемент массива arr.
            if (n % value == 0 && set.contains(n / value)) {
                return new int[]{n / value, value};
            } // Это условие проверяет, делится ли n на текущее значение value без остатка (т.е. value является делителем n) и содержится ли соответствующий множитель (n / value) в множестве set.
            // Если оба условия выполняются, это означает, что найдена пара чисел, произведение которых равно n, и функция возвращает эту пару в виде массива.
            set.add(value);
        } // Текущее значение value добавляется в множество set. Это позволяет отслеживать ранее встретившиеся элементы в массиве.
        return new int[]{}; // Возвращаем пустой массив, если пара не найдена
    }
    // Задание 5⦁	Создайте рекурсивную функцию, которая проверяет, является ли число точной верхней границей факториала n.
    // Если это так, верните массив точной факториальной границы и n, или иначе, пустой массив.
    public static int[] isExact(int number) {
        return checkFactorial(number, 1, 1);
    } // Эта функция вызывает вспомогательную рекурсивную функцию checkFactorial с начальными значениями факториала (1) и n (1).

    private static int[] checkFactorial(int number, int factorial, int n) { // Определение приватной рекурсивной функции checkFactorial, которая принимает три параметра: исходное число number,
        // текущее значение факториала factorial и число n, представляющее собой факториал какого числа мы вычисляем.
        if (factorial == number) {
            return new int[]{number, n}; // Если factorial равно number, это означает, что исходное число является факториалом числа n. Функция возвращает массив с этими двумя числами.
        } else if (factorial > number) {
            return new int[]{}; // Если factorial больше number, это означает, что исходное число не может быть факториалом какого-либо числа (поскольку факториалы возрастают очень быстро). Функция возвращает пустой массив.
        }
        return checkFactorial(number, factorial * (n + 1), n + 1); // Рекурсивный вызов функции checkFactorial с увеличенным значением n и соответствующим увеличенным значением факториала (умножением текущего факториала на n + 1).
    }
    // Задание 6 Создайте функцию, которая принимает десятичную дробь в строковой форме с повторяющейся частью в круглых скобках
    // и возвращает эквивалентную дробь в строковой форме и в наименьших членах.
    public static String fractions(String number) {
        int indexOfBracket = number.indexOf('(');
        if (indexOfBracket == -1) { // Поиск индекса открывающей скобки в строке. Если скобки нет (indexOfBracket == -1), возвращается сообщение об ошибке, указывающее на невалидный ввод.
            return "Invalid input"; // Нет повторяющейся части
        }

        String nonRepeating = number.substring(0, indexOfBracket);
        String repeating = number.substring(indexOfBracket + 1, number.length() - 1); // Извлечение неповторяющейся (nonRepeating) и повторяющейся (repeating) частей числа.

        // Вычисление длин неповторяющейся и повторяющейся частей.
        int nonRepeatingLength = nonRepeating.length() - nonRepeating.indexOf('.') - 1;
        int repeatingLength = repeating.length();

        // Преобразование неповторяющейся и повторяющейся частей в объекты BigInteger для упрощения последующих вычислений.
        BigInteger nonRepeatingPart = new BigInteger(nonRepeating.replace(".", ""));
        BigInteger repeatingPart = new BigInteger(repeating);

        // Вычисление числителя и знаменателя дроби. Числитель находится путем преобразования дроби в формат без повторяющихся чисел и вычитания неповторяющейся части. Знаменатель получается из количества цифр в обеих частях дроби.
        BigInteger numerator = nonRepeatingPart.multiply(BigInteger.TEN.pow(repeatingLength))
                .add(repeatingPart)
                .subtract(nonRepeatingPart);
        BigInteger denominator = BigInteger.TEN.pow(nonRepeatingLength + repeatingLength)
                .subtract(BigInteger.TEN.pow(nonRepeatingLength));

        // Нахождение наибольшего общего делителя (НОД) числителя и знаменателя для упрощения дроби.
        BigInteger gcd = numerator.gcd(denominator); // Находится наибольший общий делитель (НОД) числителя и знаменателя.
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd); // Числитель и знаменатель делятся на их НОД, что приводит к упрощению дроби до наименьших членов.

        return numerator + "/" + denominator;
    }

    // Задание 7 ⦁	В этой задаче преобразуйте строку в серию слов (или последовательности символов), разделенных одним пробелом,
    // причем каждое слово имеет одинаковую длину, заданную первыми 15 цифрами десятичного представления числа Пи:
    public static String pilish_string(String txt) {
        // Первые 15 цифр числа Пи
        int[] piDigits = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9}; // Инициализация массива piDigits, содержащего первые 15 цифр числа Пи.
        StringBuilder result = new StringBuilder();
        int charIndex = 0; // Инициализация объекта StringBuilder для формирования результата и переменной charIndex для отслеживания текущей позиции в строке txt.

        for (int digit : piDigits) { // Начало цикла по цифрам числа Пи.
            if (charIndex >= txt.length()) {
                break;
            } // Если текущая позиция charIndex достигает или превышает длину входной строки, цикл прерывается.

            if (result.length() > 0) {
                result.append(" ");
            } // Если в result уже есть символы, добавляется пробел перед следующим "словом".

            for (int i = 0; i < digit; i++) { // Внутренний цикл для добавления символов в "слово". Количество символов равно текущей цифре числа Пи.
                if (charIndex + i < txt.length()) {
                    result.append(txt.charAt(charIndex + i)); // Если текущий индекс в пределах строки txt, добавляется соответствующий символ.
                } else {
                    result.append(txt.charAt(txt.length() - 1));
                } // Если текущий индекс выходит за пределы строки, добавляется последний символ строки.
            }

            charIndex += digit; // Увеличивается charIndex на количество добавленных символов.
        }

        return result.toString(); // Возвращается итоговая строка, преобразованная из StringBuilder в String.
    }
    // Задание 8 Реализуйте алгоритм, который разбирает строку и вычисляет результат выражения, учитывая приоритет операций, скобки и т. д.
   // Математические операции, которые нужно поддерживать, включают в себя сложение, вычитание, умножение, деление и скобки.
    public static String evaluateExpression(String expression) {
        try { // использует блок try-catch для обработки исключений.
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operations = new Stack<>(); // Объявление двух стеков: numbers для хранения чисел и operations для хранения операций.

            for (int i = 0; i < expression.length(); i++) { // Цикл обходит каждый символ в строке expression.
                char c = expression.charAt(i);

                if (c == ' ') {
                    continue; // Пропуск пробелов в выражении.
                }

                if (c >= '0' && c <= '9') {
                    StringBuilder sb = new StringBuilder();
                    while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                        sb.append(expression.charAt(i++));
                    }
                    i--; // если символ - цифра, формируется число и помещается в стек numbers.
                    numbers.push(Double.parseDouble(sb.toString()));
                } else if (c == '(') {
                    operations.push(c);
                } else if (c == ')') {
                    while (operations.peek() != '(') {
                        numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
                    } // Обработка скобок: открывающая скобка помещается в стек операций, а при закрывающей скобке выполняются операции до встречи открывающей скобки.
                    operations.pop();
                } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                    while (!operations.empty() && hasPrecedence(c, operations.peek())) {
                        numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
                    } // Если символ - оператор, проверяется приоритет операций, и выполняются операции с более высоким приоритетом перед помещением нового оператора в стек.
                    operations.push(c);
                }
            }

            while (!operations.empty()) { // После обхода всего выражения, выполняются оставшиеся операции.
                numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
            }

            return numbers.pop().toString(); // Возвращается результат выражения. Если произошло исключение, возвращается сообщение об ошибке.
        } catch (Exception e) {
            return "Error: Invalid Expression";
        }
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false; // Определяет, должен ли оператор op1 быть выполнен перед оператором op2.
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    public static double applyOperation(char op, double b, double a) { // // Выполняет операцию op на числах a и b. В случае деления на ноль генерируется исключение.
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }
    // Задание 9⦁	Шерлок считает строку действительной, если все символы строки встречаются одинаковое количество раз. Также допустимо, если он может удалить только 1 символ из 1 индекса в строке,
    // а остальные символы будут встречаться одинаковое количество раз. Для данной строки str определите, действительна ли она. Если да, верните «ДА», в противном случае верните «НЕТ».
    public static String isValid(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>(); // Создание HashMap для хранения частоты каждого символа в строке.

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // Подсчет частоты каждого символа в строке s.
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        Map<Integer, Integer> freqOfFreq = new HashMap<>(); // Создание еще одного HashMap для хранения частоты частот (т.е., сколько раз встречается каждая частота символов).
        for (int freq : frequencyMap.values()) { // Заполнение freqOfFreq на основе данных из frequencyMap.
            freqOfFreq.put(freq, freqOfFreq.getOrDefault(freq, 0) + 1);
        }

        // Анализируем частоту частот
        if (freqOfFreq.size() == 1) {
            return "YES"; // Если в freqOfFreq только одно значение, это означает, что все символы в строке встречаются одинаковое количество раз.
        } else if (freqOfFreq.size() == 2) { // Если в freqOfFreq два значения, то возможно создать валидную строку, удалив один символ.
            if (freqOfFreq.containsKey(1) && freqOfFreq.get(1) == 1) {
                return "YES"; // Случай, когда один символ встречается только один раз.
            }

            // Находим две различные частоты
            int f1 = 0, f2 = 0, countF1 = 0, countF2 = 0;
            for (Map.Entry<Integer, Integer> entry : freqOfFreq.entrySet()) {
                if (f1 == 0) {
                    f1 = entry.getKey();
                    countF1 = entry.getValue();
                } else {
                    f2 = entry.getKey();
                    countF2 = entry.getValue();
                } // Извлечение двух различных частот и их количеств из freqOfFreq.
            }

            // Проверяем, можно ли удалить один символ, чтобы сделать частоты одинаковыми
            if ((countF1 == 1 && (f1 - 1 == f2 || f1 == 1)) || (countF2 == 1 && (f2 - 1 == f1 || f2 == 1))) {
                return "YES"; // Проверка, можно ли сделать все частоты одинаковыми путем удаления одного символа.
            }
        }

        return "NO"; // Возвращается "NO", если строка не может быть сделана валидной.
    }
    // Задание 10 Создайте функцию, которая будет находить наибольшую общую подпоследовательность (LCS) для двух строк.
    // LCS – это самая длинная последовательность символов, которая встречается как подпоследовательность в обеих строках.
    // Эта задача требует понимания алгоритма динамического программирования для нахождения наибольшей общей подпоследовательности и его эффективной реализации.
    public static String findLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length(); // Получение длин строк s1 и s2.

        int[][] dp = new int[m + 1][n + 1]; // Создание двумерного массива dp для хранения длин наибольших общих подпоследовательностей для подстрок s1 и s2.

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) { // Двойной цикл для заполнения таблицы dp. Он проходит через все возможные комбинации подстрок s1 и s2.
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                } // Заполнение таблицы dp. Если символы в текущих позициях обеих строк совпадают, увеличиваем значение на 1 от предыдущего максимума.
                // Если символы не совпадают, выбираем максимальное значение из соседних ячеек.
            }
        }

        int index = dp[m][n];
        char[] lcs = new char[index];
        int i = m, j = n; // Инициализация массива lcs для хранения наибольшей общей подпоследовательности и установка индексов i и j для обратного прохода по таблице dp.

        while (i > 0 && j > 0) { // Обратный проход по таблице dp для восстановления LCS.
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[index - 1] = s1.charAt(i - 1);
                i--;
                j--;
                index--; // Если символы в s1 и s2 совпадают, добавляем этот символ в lcs. Иначе перемещаемся в сторону большего значения в таблице dp.
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new String(lcs); // Возвращаем наибольшую общую подпоследовательность в виде строки.
    }
}