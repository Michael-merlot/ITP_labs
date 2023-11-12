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

    private static final double RING_DISTANCE = 1.0;
    private static final double RADIAL_ANGLE = Math.toRadians(45);

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
            return false;
        }

        Map<Character, Character> patternMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (patternMap.containsKey(ch1)) {
                if (patternMap.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (patternMap.containsValue(ch2)) {
                    return false;
                }
                patternMap.put(ch1, ch2);
            }
        }
        return true;
    }
// Задание 2 Паутина определяется кольцами, пронумерованными от 0 до 4 от центра, и радиалами, помеченными по часовой стрелке сверху как A-H.
//Создайте функцию, которая принимает координаты паука и мухи и
// возвращает кратчайший путь для паука, чтобы добраться до мухи.

    public static String spiderVsFly(String spider, String fly) {
        char spiderRadial = spider.charAt(0);
        int spiderRing = spider.charAt(1) - '0';
        char flyRadial = fly.charAt(0);
        int flyRing = fly.charAt(1) - '0';

        if (spiderRadial == flyRadial) {
            // Move along the radial
            return moveAlongRadial(spider, fly, spiderRing, flyRing);
        } else if (spiderRing == flyRing) {
            // Move along the ring
            return moveAlongRing(spider, fly);
        } else {
            // Calculate the two possible paths and choose the shorter one
            String pathViaCenter = moveAlongRadial(spider, String.valueOf(spiderRadial) + '0', spiderRing, 0) +
                    moveAlongRadial(String.valueOf(flyRadial) + '0', fly, 0, flyRing);
            String pathViaRing = moveAlongRing(spider, String.valueOf(spiderRadial) + flyRing) +
                    moveAlongRadial(String.valueOf(spiderRadial) + flyRing, fly, flyRing, flyRing);

            double distanceViaCenter = calculateDistance(spider, String.valueOf(spiderRadial) + '0') +
                    calculateDistance(String.valueOf(flyRadial) + '0', fly);
            double distanceViaRing = calculateDistance(spider, String.valueOf(spiderRadial) + flyRing) +
                    calculateDistance(String.valueOf(spiderRadial) + flyRing, fly);

            return distanceViaCenter <= distanceViaRing ? pathViaCenter : pathViaRing;
        }
    }

    private static String moveAlongRadial(String start, String end, int startRing, int endRing) {
        StringBuilder path = new StringBuilder(start);
        if (startRing > endRing) {
            for (int i = startRing - 1; i >= endRing; i--) {
                path.append("-").append(start.charAt(0)).append(i);
            }
        } else {
            for (int i = startRing + 1; i <= endRing; i++) {
                path.append("-").append(start.charAt(0)).append(i);
            }
        }
        return path.toString();
    }

    private static String moveAlongRing(String start, String end) {
        char startRadial = start.charAt(0);
        char endRadial = end.charAt(0);
        int ring = start.charAt(1) - '0';

        int startRadialIndex = startRadial - 'A';
        int endRadialIndex = endRadial - 'A';

        StringBuilder path = new StringBuilder(start);
        int steps = Math.min(Math.abs(endRadialIndex - startRadialIndex), 8 - Math.abs(endRadialIndex - startRadialIndex));
        int direction = (endRadialIndex - startRadialIndex + 8) % 8 > 4 ? -1 : 1;

        for (int i = 1; i <= steps; i++) {
            int radialIndex = (startRadialIndex + direction * i + 8) % 8;
            char radial = (char) ('A' + radialIndex);
            path.append("-").append(radial).append(ring);
        }

        return path.toString();
    }

    private static double calculateDistance(String start, String end) {
        char startRadial = start.charAt(0);
        int startRing = start.charAt(1) - '0';
        char endRadial = end.charAt(0);
        int endRing = end.charAt(1) - '0';

        if (startRing == 0 || endRing == 0) {
            // One of the points is at the center
            return Math.abs(startRing - endRing) * RING_DISTANCE;
        } else {
            // Both points are on the web
            int radialDiff = Math.abs(startRadial - endRadial);
            radialDiff = Math.min(radialDiff, 8 - radialDiff); // Shortest way around the web
            double angleDifference = radialDiff * RADIAL_ANGLE;
            return Math.sqrt(Math.pow(startRing, 2) + Math.pow(endRing, 2) - 2 * startRing * endRing * Math.cos(angleDifference));
        }
    }

// Задание 3 ⦁	Создайте функцию, которая будет рекурсивно подсчитывать количество цифр числа.
// Преобразование числа в строку не допускается, поэтому подход является рекурсивным
public static int digitsCount(long n) {
    // Base case: if the number is between 0 and 9, it has 1 digit
    if (n >= 0 && n <= 9) {
        return 1;
    }
    // Recursive case: remove the last digit and add 1 to the count
    return 1 + digitsCount(n / 10);
    }

// Задание 4 ⦁	Игроки пытаются набрать очки, формируя слова, используя буквы из 6-буквенного скремблированного слова.
// Они выигрывают раунд, если им удается успешно расшифровать слово из 6 букв.
    public static int totalPoints(String[] guesses, String word) {
        int totalPoints = 0;
        for (String guess : guesses) {
            if (isValidWord(guess, word)) {
                totalPoints += getWordPoints(guess, word);
            }
        }
        return totalPoints;
    }

    private static boolean isValidWord(String guess, String word) {
        Map<Character, Integer> letterCounts = new HashMap<>();
        for (char c : word.toCharArray()) {
            letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
        }

        for (char c : guess.toCharArray()) {
            if (!letterCounts.containsKey(c) || letterCounts.get(c) == 0) {
                return false;
            }
            letterCounts.put(c, letterCounts.get(c) - 1);
        }
        return true;
    }

    private static int getWordPoints(String guess, String word) {
        if (guess.length() == 3) {
            return 1;
        } else if (guess.length() == 4) {
            return 2;
        } else if (guess.length() == 5) {
            return 3;
        } else if (guess.length() == 6) {
            if (guess.equals(word)) {
                return 54; // 4 points + 50 points bonus
            }
            // Check for anagrams
            Map<Character, Integer> guessCounts = new HashMap<>();
            Map<Character, Integer> wordCounts = new HashMap<>();
            for (char c : guess.toCharArray()) {
                guessCounts.put(c, guessCounts.getOrDefault(c, 0) + 1);
            }
            for (char c : word.toCharArray()) {
                wordCounts.put(c, wordCounts.getOrDefault(c, 0) + 1);
            }
            if (guessCounts.equals(wordCounts)) {
                return 54; // 4 points + 50 points bonus for anagrams
            }
        }
        return 0;
    }
// Задание 5 Создайте функцию, которая получает каждую пару чисел из массива,
// который суммирует до восьми, и возвращает его как массив пар (отсортированный по возрастанию).
    public static List<List<Integer>> sumsUp(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> pairs = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 8) {
                pairs.add(Arrays.asList(arr[left], arr[right]));
                left++;
                right--;
            } else if (sum < 8) {
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }

// Задание 6 Какой процент вы можете набрать на тесте, который в одиночку снижает средний балл по классу на 5%?
// Учитывая массив оценок ваших одноклассников, создайте функцию, которая возвращает ответ.
// Округлите до ближайшего процента.
public static String takeDownAverage(String[] scores) {
    // Calculate current average
    double currentAverage = Arrays.stream(scores)
            .mapToInt(score -> Integer.parseInt(score.replace("%", "")))
            .average()
            .orElse(0);

    // New average after decreasing by 5%
    double newAverage = currentAverage - 5;

    // Calculate the score to achieve this new average
    int n = scores.length;
    double requiredScore = newAverage * (n + 1) - currentAverage * n;

    // Round to nearest percent and format as string
    requiredScore = Math.max(0, requiredScore); // Score can't be negative
    return String.format("%d%%", Math.round(requiredScore));
}

// Задание 7 Создайте функцию, которая будет шифровать и дешифровать сообщения с использованием шифра Цезаря. Шифр Цезаря – это метод шифрования,
// в котором каждая буква в сообщении сдвигается на фиксированное количество позиций в алфавите.
public static String caesarCipher(String mode, String message, int shift) {
    StringBuilder result = new StringBuilder();
    // Adjust shift for decoding
    if (mode.equals("decode")) {
        shift = 26 - (shift % 26);
    }

    for (char character : message.toCharArray()) {
        if (character >= 'A' && character <= 'Z') {
            // Shift character within the bounds of uppercase letters
            char shiftedChar = (char) ((character - 'A' + shift) % 26 + 'A');
            result.append(shiftedChar);
        } else if (character >= 'a' && character <= 'z') {
            // Convert to uppercase and shift
            char shiftedChar = (char) (((character - 'a') + shift) % 26 + 'A');
            result.append(shiftedChar);
        } else {
            // Leave non-alphabetical characters unchanged
            result.append(character);
        }
    }

    return result.toString();
}

// Задание 8 Создайте метод для рекурсивного вычисления количества различных способов
// как можно разместить k элементов из множества из n элементов без повторений
public static int setSetup(int n, int k) {
    return factorial(n) / factorial(n - k);
}

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

// Задание 9 В этой задаче цель состоит в том, чтобы вычислить, сколько времени сейчас в двух разных городах.
// Вы должны вернуть новую метку времени с датой и соответствующим временем
public static String timeDifference(String cityA, String timestamp, String cityB) {
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.ENGLISH);
    LocalDateTime localDateTime = LocalDateTime.parse(timestamp, inputFormatter);

    ZonedDateTime zonedDateTimeA = ZonedDateTime.of(localDateTime, ZoneOffset.of(timeZones.get(cityA)));
    ZonedDateTime zonedDateTimeB = zonedDateTimeA.withZoneSameInstant(ZoneOffset.of(timeZones.get(cityB)));

    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
    return zonedDateTimeB.format(outputFormatter);
}


// Задание 10 Напишите функцию, которая принимает неотрицательное целое число и возвращает true, если целое число является новым числом, и false, если это не так.
public static boolean isNew(int num) {
    String numStr = Integer.toString(num);
    char[] digits = numStr.toCharArray();
    Arrays.sort(digits);
    String sortedStr = new String(digits);

    // Check if the sorted number is the same as the original or starts with a zero
    return sortedStr.equals(numStr) || sortedStr.charAt(0) != '0';
}
}