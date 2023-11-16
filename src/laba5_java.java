import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Locale;

public class laba5_java {
    private static final Map<String, String> timeZones = new HashMap<>();
    static {
        timeZones.put("Los Angeles", "-08:00");
        timeZones.put("New York", "-05:00");
        timeZones.put("Caracas", "-04:30");
        timeZones.put("Buenos Aires", "-03:00");
        timeZones.put("London", "Z");
        timeZones.put("Rome", "+01:00");
        timeZones.put("Moscow", "+03:00");
        timeZones.put("Tehran", "+03:30");
        timeZones.put("New Delhi", "+05:30");
        timeZones.put("Beijing", "+08:00");
        timeZones.put("Canberra", "+10:00");
    }

    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD")); // ➞ true
        System.out.println(sameLetterPattern("ABCBA", "BCDCB")); // ➞ true
        System.out.println(sameLetterPattern("FFGG", "CDCD")); // ➞ false
        System.out.println(sameLetterPattern("FFFF", "ABCD")); // ➞ false
        System.out.println("---");

        System.out.println(spiderVsFly("H3", "E2")); // ➞ "H3-H2-H1-A0-E1-E2"
        System.out.println(spiderVsFly("A4", "B2")); // ➞ "A4-A3-A2-B2"
        System.out.println(spiderVsFly("A4", "C2")); // ➞ "A4-A3-A2-B2-C2"
        System.out.println("---");

        System.out.println(digitsCount(4666)); // ➞ 4
        System.out.println(digitsCount(544)); // ➞ 3
        System.out.println(digitsCount(121317)); // ➞ 6
        System.out.println(digitsCount(0)); // ➞ 1
        System.out.println(digitsCount(12345)); // ➞ 5
        System.out.println(digitsCount(1289396387328L)); // ➞ 13
        System.out.println("---");

        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster")); // ➞ 2
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant")); // ➞ 108
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed")); // ➞ 13
        System.out.println("---");

        System.out.println(sumsUp(new int[]{1, 2, 3, 4, 5})); // ➞ [[3, 5]]
        System.out.println(sumsUp(new int[]{1, 2, 3, 7, 9})); // ➞ [[1, 7]]
        System.out.println(sumsUp(new int[]{10, 9, 7, 2, 8})); // ➞ []
        System.out.println(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7})); // ➞ [[2, 6], [3, 5], [1, 7]]
        System.out.println("---");

        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"})); // ➞ "54%"
        System.out.println(takeDownAverage(new String[]{"10%"})); // ➞ "0%"
        System.out.println(takeDownAverage(new String[]{"53%", "79%"})); // ➞ "51%"
        System.out.println("---");

        System.out.println(caesarCipher("encode", "hello world", 3)); // ➞ "KHOOR ZRUOG"
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4)); // ➞ "ALMOST LAST TASK!"
        System.out.println("---");

        System.out.println(setSetup(5, 3)); // ➞ 60
        System.out.println(setSetup(7, 3)); // ➞ 210
        System.out.println("---");

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra")); // ➞ "2011-4-2 17:23"
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome")); // ➞ "1983-8-1 00:01"
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing")); // ➞ "1971-1-1 02:40"
        System.out.println("---");

        System.out.println(isNew(3)); // ➞ true
        System.out.println(isNew(30)); // ➞ true
        System.out.println(isNew(321)); // ➞ false
        System.out.println(isNew(123)); // ➞ true
        System.out.println("---");

    }

    // Задание 1 Создайте функцию, которая возвращает true, если две строки имеют один и тот же буквенный шаблон, и false в противном случае.
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false; // Если не совпадают,возвращает false
        }

        Map<Character, Character> patternMap = new HashMap<>(); // Создается карта для хранения символов первой и второй строки.
        for (int i = 0; i < str1.length(); i++) { // по каждому символу первой строки.
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i); // Получение текущих символов обеих строк на позиции i.

            if (patternMap.containsKey(ch1)) { // Если символ из первой строки уже есть в карте, проверяется соответствие его пары символу из второй строки.
                if (patternMap.get(ch1) != ch2) {
                    return false; // не пара не совпадает
                }
            } else {
                if (patternMap.containsValue(ch2)) {
                    return false;
                } // Если символ из первой строки еще не в карте, проверяется, не сопоставлен ли уже символ из второй строки другому символу. Если нет, пара добавляется в карту.
                patternMap.put(ch1, ch2);
            }
        }
        return true;
    }
// Задание 2 Паутина определяется кольцами, пронумерованными от 0 до 4 от центра, и радиалами, помеченными по часовой стрелке сверху как A-H.
//Создайте функцию, которая принимает координаты паука и мухи и
// возвращает кратчайший путь для паука, чтобы добраться до мухи.

    private static final String RADIALS = "ABCDEFGH"; // Строка для представления радиалов
// final - иниц один раз и класс не может быть унаследован
    public static String spiderVsFly(String spider, String fly) {
        int spiderRadial = RADIALS.indexOf(spider.charAt(0)); // индекс радиала, на котором находится паук.
        int spiderRing = Character.getNumericValue(spider.charAt(1)); // Определяется номер кольца, на котором находится паук
        int flyRadial = RADIALS.indexOf(fly.charAt(0)); // определяется индекс радиала для мухи.
        int flyRing = Character.getNumericValue(fly.charAt(1)); // Определяется номер кольца для мухи

        StringBuilder path = new StringBuilder(spider); // начальная позиция паука

        // Если паук и муха находятся на одном радиале
        if (spiderRadial == flyRadial) {
            for (int i = spiderRing - 1; i >= flyRing; i--) {
                path.append("-").append(RADIALS.charAt(spiderRadial)).append(i);
            }
        } else { // Если паук и муха находятся на разных радиалах
            int angleDistance = Math.min(Math.abs(spiderRadial - flyRadial), RADIALS.length() - Math.abs(spiderRadial - flyRadial));
            // Вычисляется кратчайшее угловое расстояние между радиалами паука и мухи.
            if (angleDistance < 3 || spiderRing == 0 || flyRing == 0) {
                // Спускаемся или поднимаемся по кольцам (true- -1, false - 1)
                int ringChange = spiderRing > flyRing ? -1 : 1;
                for (int ring = spiderRing; ring != flyRing; ring += ringChange) {
                    path.append("-").append(RADIALS.charAt(spiderRadial)).append(ring + ringChange);
                }
                // Перемещаемся по кольцу к нужному радиалу
                int radialChange = spiderRadial < flyRadial ? 1 : -1;
                if (Math.abs(spiderRadial - flyRadial) > RADIALS.length() / 2) {
                    radialChange = -radialChange; // Если короче идти в другую сторону
                }
                for (int radial = spiderRadial; radial != flyRadial; radial = (radial + radialChange + RADIALS.length()) % RADIALS.length()) {
                    path.append("-").append(RADIALS.charAt((radial + radialChange + RADIALS.length()) % RADIALS.length())).append(flyRing);
                }
            } else {
                // Спускаемся в центр
                for (int i = spiderRing; i > 0; i--) {
                    path.append("-").append(RADIALS.charAt(spiderRadial)).append(i);
                }
                // Перемещаемся по центру к нужному радиалу
                path.append("-A0");
                for (int i = 1; i <= flyRing; i++) {
                    path.append("-").append(RADIALS.charAt(flyRadial)).append(i);
                }
            }
        }
        // Возвращаем путь как строку
        return path.toString();
    }


    // Задание 3 ⦁	Создайте функцию, которая будет рекурсивно подсчитывать количество цифр числа.
// Преобразование числа в строку не допускается, поэтому подход является рекурсивным
    public static int digitsCount(long n) {

        if (n >= 0 && n <= 9) { // Это базовый случай рекурсии, от 0 до 9
            return 1;
        }

        return 1 + digitsCount(n / 10); // Это рекурсивный случай.
    }

    // Задание 4 ⦁	Игроки пытаются набрать очки, формируя слова, используя буквы из 6-буквенного скремблированного слова.
// Они выигрывают раунд, если им удается успешно расшифровать слово из 6 букв.
    public static int totalPoints(String[] guesses, String word) {
        int totalPoints = 0; // для хранения общего количества очков.
        for (String guess : guesses) { // перебирает все догадки в массиве guesses.
            if (isValidWord(guess, word)) { // является ли текущая догадка guess допустимым словом
                totalPoints += getWordPoints(guess, word);
            }
        }
        return totalPoints; // общее кол-во очков
    }

    private static boolean isValidWord(String guess, String word) {
        Map<Character, Integer> letterCounts = new HashMap<>(); // Создается карта для подсчета количества каждой буквы в исходном слове.
        for (char c : word.toCharArray()) { // каждую букву в ворд
            letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
        } // заполняет карту letterCounts, подсчитывая количество каждой буквы в слове word.

        for (char c : guess.toCharArray()) { // каждую букву
            if (!letterCounts.containsKey(c) || letterCounts.get(c) == 0) {
                return false; // если нет буквы в ворд или равна нулю
            }
            letterCounts.put(c, letterCounts.get(c) - 1); // обновление карты леттеркаунтс хранит кол-во каждый буквы ворд
        }
        return true;
    }

    private static int getWordPoints(String guess, String word) {
        if (guess.length() == 3) {
            return 1;
        } else if (guess.length() == 4) {
            return 2;
        } else if (guess.length() == 5) {
            return 3; // В зависимости от длины возвращаются различные количество очков.
        } else if (guess.length() == 6) {
            if (guess.equals(word)) { // если гуес=ворд то 54 очка
                return 54; // Возвращается 54 очка за точное совпадение иначе возвращается 0 очков.
            }

            Map<Character, Integer> guessCounts = new HashMap<>(); // для хранения количества каждой буквы
            Map<Character, Integer> wordCounts = new HashMap<>(); // для хранения количества каждой буквы
            for (char c : guess.toCharArray()) {
                guessCounts.put(c, guessCounts.getOrDefault(c, 0) + 1);
            } // каждая буква в карту гуес-каунтс, если буква есть в карте то кол-во на +1
            for (char c : word.toCharArray()) {
                wordCounts.put(c, wordCounts.getOrDefault(c, 0) + 1);
            }
            if (guessCounts.equals(wordCounts)) {
                return 54; // если гуес является ворд то 54 очка (за анаграму)
            }
        }
        return 0;
    }

    // Задание 5 Создайте функцию, которая получает каждую пару чисел из массива,
// который суммирует до восьми, и возвращает его как массив пар (отсортированный по возрастанию).
    public static List<List<Integer>> sumsUp(int[] arr) {
        Arrays.sort(arr); // по возрастанию. Это упрощает последующий поиск пар, сумма которых равна 8.
        List<List<Integer>> pairs = new ArrayList<>(); // для хранения найденных пар чисел.
        int left = 0; // начало массива
        int right = arr.length - 1; // конец массива

        while (left < right) { // пока не пересекутся
            int sum = arr[left] + arr[right];
            if (sum == 8) {
                pairs.add(Arrays.asList(arr[left], arr[right]));
                left++;
                right--; // если равна 8 то указатели сдвигаются внутрь массива
            } else if (sum < 8) { // указатель влево для уменьшений суммы
                left++;
            } else {
                right--;
            }
        }

        return pairs; // в сумме дают 8
    }

    // Задание 6 Какой процент вы можете набрать на тесте, который в одиночку снижает средний балл по классу на 5%?
// Учитывая массив оценок ваших одноклассников, создайте функцию, которая возвращает ответ.
// Округлите до ближайшего процента.
    public static String takeDownAverage(String[] scores) {
        // преобразует массив строк в поток, удаляет символы процента, преобразует оставшиеся значения в числа,
        // вычисляет среднее и возвращает его. Если массив пуст, возвращается 0.
        double currentAverage = Arrays.stream(scores)
                .mapToInt(score -> Integer.parseInt(score.replace("%", "")))
                .average()
                .orElse(0);

        //  Вычитается 5% из текущего среднего, чтобы получить новое среднее.
        double newAverage = currentAverage - 5;

        //  количество текущих оценок.
        int n = scores.length;
        double requiredScore = newAverage * (n + 1) - currentAverage * n; // требуемый балл

        // результат не будет отрицательным.
        requiredScore = Math.max(0, requiredScore); // Округляется до ближайшего целого числа и форматируется как строка с процентом.
        return String.format("%d%%", Math.round(requiredScore));
    } // %d - инт (%% - для вставски символа процента в строку)
    // math.round - используется для округления числа с плавающей точкой

    // Задание 7 Создайте функцию, которая будет шифровать и дешифровать сообщения с использованием шифра Цезаря. Шифр Цезаря – это метод шифрования,
// в котором каждая буква в сообщении сдвигается на фиксированное количество позиций в алфавите.
    public static String caesarCipher(String mode, String message, int shift) {
        StringBuilder result = new StringBuilder(); // для эффективного построения результата.
        if (mode.equals("decode")) { // если декод - возвращаться назад по алфавиту.
            shift = 26 - (shift % 26);
        }

        for (char character : message.toCharArray()) { // обходит каждый символ в сообщении.
            if (character >= 'A' && character <= 'Z') { // Если символ - заглавная буква, он сдвигается в пределах алфавита.
                char shiftedChar = (char) ((character - 'A' + shift) % 26 + 'A');
                result.append(shiftedChar); // Вычисляется сдвинутый символ для заглавных букв.
            } else if (character >= 'a' && character <= 'z') { // Если символ - строчная буква, он преобразуется в заглавную и сдвигается.
                char shiftedChar = (char) (((character - 'a') + shift) % 26 + 'A');
                result.append(shiftedChar); // Вычисляется сдвинутый символ для строчных букв, который также преобразуется в заглавную букву.
            } else {
                result.append(character); // В обоих случаях сдвинутый символ добавляется к результату.
            } // Если символ не является буквой алфавита, он добавляется к результату без изменений.
        }

        return result.toString();
    }

    // Задание 8 Создайте метод для рекурсивного вычисления количества различных способов
// как можно разместить k элементов из множества из n элементов без повторений
    public static int setSetup(int n, int k) {
        return factorial(n) / factorial(n - k); // результат деления факториала n на факториал n-k
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1); // n! = n * (n-1)!
    }

    // Задание 9 В этой задаче цель состоит в том, чтобы вычислить, сколько времени сейчас в двух разных городах.
// Вы должны вернуть новую метку времени с датой и соответствующим временем
    public static String timeDifference(String cityA, String timestamp, String cityB) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.ENGLISH); // Создается объект DateTimeFormatter для парсинга строковой временной метки.
        LocalDateTime localDateTime = LocalDateTime.parse(timestamp, inputFormatter); // Исходная временная метка преобразуется в объект LocalDateTime.

        ZonedDateTime zonedDateTimeA = ZonedDateTime.of(localDateTime, ZoneOffset.of(timeZones.get(cityA))); //  Преобразуется LocalDateTime в ZonedDateTime, используя часовой пояс первого города.
        ZonedDateTime zonedDateTimeB = zonedDateTimeA.withZoneSameInstant(ZoneOffset.of(timeZones.get(cityB))); // для первого города преобразуется в ZonedDateTime для второго города, сохраняя тот же момент времени.

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm"); // Создается новый DateTimeFormatter для вывода результата.
        return zonedDateTimeB.format(outputFormatter);
    } // ofPattern для создания форматтера даты с шаблоном


    // Задание 10 Напишите функцию, которая принимает неотрицательное целое число и возвращает true, если целое число является новым числом, и false, если это не так.
    public static boolean isNew(int number) {
        if (number < 10) {
            return true; // оно автоматически считается "новым числом".
        }

        String numberStr = Integer.toString(number); // Число преобразуется в строку.
        char[] numberChars = numberStr.toCharArray(); // Строка преобразуется в массив символов.
        Arrays.sort(numberChars); // Массив символов сортируется.

        for (int i = 1; i < number; i++) { // перебирает все числа меньше заданного number.
            String smallerNumberStr = Integer.toString(i);
            char[] smallerNumberChars = smallerNumberStr.toCharArray();
            Arrays.sort(smallerNumberChars); // каждое число преобразуется в отсортированный массив символов

            if (Arrays.equals(numberChars, smallerNumberChars)) {
                return false; // Найдено меньшее число с теми же цифрами
            }
        }

        return true; // Новое число
    }
}

