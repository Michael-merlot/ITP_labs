import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.Arrays;

public class laba2_java {
    public static void main(String[] args) {
        // Тестирование функции duplicateChars
        System.out.println(duplicateChars("Donald"));  // true
        System.out.println(duplicateChars("orange"));  // false

        // Тестирование функции getInitials
        System.out.println(getInitials("Ryan Gosling"));  // RG
        System.out.println(getInitials("Barack Obama"));  // BA

        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));  // 143
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));  // 61

        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 5}));  // true
        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 6}));  // false

        printArray(indexMult(new int[]{1, 2, 3}));  // [0, 2, 6]
        printArray(indexMult(new int[]{3, 3, -2, 408, 3, 31}));  // [0, 3, -4, 1224, 15, 186]

        System.out.println(reverse("Hello World"));       // "dlroW olleH"
        System.out.println(reverse("The quick brown fox."));  // ".xof nworb kciuq ehT"

        System.out.println(Tribonacci(6));  // 7
        System.out.println(Tribonacci(10));  // 81

        System.out.println(pseudoHash(5));  // Например: "04bf2"
        System.out.println(pseudoHash(10));  // Например: "2d9c45e1f3"
        System.out.println(pseudoHash(0));  // ""

        System.out.println(botHelper("Hello, I’m under the water, please help me"));  // "Вызов сотрудника"
        System.out.println(botHelper("Two pepperoni pizzas please"));  // "Продолжайте ожидание"

        System.out.println(isAnagram("listen", "silent"));  // true
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));  // true
        System.out.println(isAnagram("hello", "world"));  // false
    }

// 1 задание

    public static boolean duplicateChars(String s) {
        Set<Character> charSet = new HashSet<>();

        String lowerCaseStr = s.toLowerCase();

        for (char c : lowerCaseStr.toCharArray()) {
            if (charSet.contains(c)) {
                return true;
            }
            charSet.add(c);
        }
        return false;
    }

// 2 задание

    public static String getInitials(String name) {
        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Input should contain exactly two words");
        }

        return (parts[0].charAt(0) + "" + parts[1].charAt(0)).toUpperCase();
    }

// 3 задание

    public static int differenceEvenOdd(int[] numbers) {
        int sum = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {  // Если число четное
                sum -= num;
            } else {             // Если число нечетное
                sum += num;
            }
        }

        return Math.abs(sum); // Возвращаем абсолютное значение разницы
    }

// 4 задание

    public static boolean equalToAvg(int[] numbers) {
        int sum = 0;

        // Считаем сумму всех элементов массива
        for (int num : numbers) {
            sum += num;
        }

        // Вычисляем среднее арифметическое
        double avg = (double) sum / numbers.length;

        // Проверяем, есть ли в массиве элемент, равный среднему арифметическому
        for (int num : numbers) {
            if (num == avg) {
                return true;
            }
        }

        return false;
    }

// 5 задание

    public static int[] indexMult(int[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = numbers[i] * i;
        }

        return result;
    }

    // Вспомогательный метод для вывода массива
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

// 6 задание

    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

// 7 задание

    public static int Tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return 1;

        int first = 0, second = 0, third = 1;

        for (int i = 3; i <= n; i++) {
            int current = first + second + third;
            first = second;
            second = third;
            third = current;
        }

        return third;
    }

// 8 задание

    public static String pseudoHash(int length) {
        if (length <= 0) {
            return "";
        }

        String characters = "0123456789abcdef";
        StringBuilder result = new StringBuilder(length);
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = rand.nextInt(characters.length());
            result.append(characters.charAt(randomIndex));
        }

        return result.toString();
    }

// 9 задание

    public static String botHelper(String message) {
        if (message.toLowerCase().contains("help")) {
            return "Вызов сотрудника";
        } else {
            return "Продолжайте ожидание";
        }
    }

// 10 задание

    public static boolean isAnagram(String str1, String str2) {
        return sortString(cleanString(str1)).equals(sortString(cleanString(str2)));
    }

    private static String cleanString(String str) {
        return str.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}