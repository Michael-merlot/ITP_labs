import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;

public class laba3_java {
    public static void main(String[] args) {

        System.out.println(replaceVowels("apple"));
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println("---");

        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println("---");

        System.out.println(doesBlockFit(1, 3, 5, 4, 5));  // true
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));  // true
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));  // false
        System.out.println("---");

        System.out.println(numCheck(243));  // true
        System.out.println(numCheck(52));   // false
        System.out.println("---");

        System.out.println(countRoots(new int[]{1, -3, 2}));  // 2
        System.out.println(countRoots(new int[]{2, 5, 2}));  // 0
        System.out.println(countRoots(new int[]{1, -6, 9})); // 1
        System.out.println("---");

        String[][] data1 = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        };

        String[][] data2 = {
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        };

        System.out.println(salesData(data1));
        System.out.println(salesData(data2));
        System.out.println("---");

        System.out.println(validSplit("apple eagle egg goat"));  // true
        System.out.println(validSplit("cat dog goose fish"));   // false
        System.out.println("---");

        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));  // true
        System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));      // false
        System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));    // true
        System.out.println("---");

        System.out.println(commonVowel("Hello world"));  // "o"
        System.out.println(commonVowel("Actions speak louder than words."));  // "o"
        System.out.println("---");

        int[][] data = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };

        dataScience(data);
        printMatrix(data);

        data = new int[][] {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };

        dataScience(data);
        printMatrix(data);
    }

    // 1 задание
    public static String replaceVowels(String word) {
        return word.replaceAll("(?i)[aeiouy]", "*");
    }
// 2 задание

    public static String stringTransform(String word){
        char[] wordIn = word.toCharArray();
        String simb = "";
        for (int i = 1; i < wordIn.length; i++){
            if (wordIn[i] == wordIn[i-1]){
                simb = String.valueOf(wordIn[i]);
                word = word.replace((simb + simb), "Double" + simb);
            }
        }
        return word;
    }

// 3 задание

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        // Проверка всех возможных комбинаций сторон блока с размерами отверстия
        if ((a <= w && b <= h) || (a <= h && b <= w)) return true;
        if ((a <= w && c <= h) || (a <= h && c <= w)) return true;
        if ((b <= w && c <= h) || (b <= h && c <= w)) return true;

        return false;
    }

// 4 задание

    public static boolean numCheck(int num) {
        int sumOfSquares = 0;
        int temp = num;

        // Вычисляем сумму квадратов всех цифр числа
        while (temp > 0) {
            int digit = temp % 10;
            sumOfSquares += digit * digit;
            temp /= 10;
        }

        // Проверяем четность суммы и самого числа
        return (sumOfSquares % 2 == num % 2);
    }

// 5 задание

    public static int countRoots(int[] args){
        int D = args[1] * args[1] - 4 * args[0] * args[2];
        double x1 = (-args[1] + Math.sqrt(D))/(2 * args[0]);
        double x2 = (-args[1] - Math.sqrt(D))/(2 * args[0]);
        if (D >= 0){
            if (x1 == Math.floor(x1) && x2 == Math.floor(x2)){
                if (x1 != x2){
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }

// 6 задание

    public static ArrayList<String> salesData(String[][] salesIn){
        ArrayList<String> maxSalesItems = new ArrayList<>();
        int maxSales = 0;

        for (String[] item : salesIn) {
            int currentSales = item.length - 1;  // -1 to exclude the name of the item

            if (currentSales > maxSales) {
                maxSales = currentSales;
                maxSalesItems.clear();
                maxSalesItems.add(item[0]);
            } else if (currentSales == maxSales) {
                maxSalesItems.add(item[0]);
            }
        }

        return maxSalesItems;
    }


// 7 задание

    public static boolean validSplit(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            char lastChar = words[i].charAt(words[i].length() - 1);
            char firstCharNextWord = words[i + 1].charAt(0);
            if (lastChar != firstCharNextWord) {
                return false;
            }
        }
        return true;
    }

// 8 задание

    public static boolean waveForm(int[] arr) {
        if (arr.length < 2) {
            return false;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // For even indices (0-based)
            if (i % 2 == 0) {
                if (arr[i] <= arr[i + 1]) {
                    return false;
                }
            }
            // For odd indices
            else {
                if (arr[i] >= arr[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

// 9 задание

    public static String commonVowel(String sentence) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        String vowels = "aeiouAEIOU";
        char mostCommon = ' ';
        int maxCount = 0;

        for (char i : sentence.toCharArray()) {
            if (vowels.indexOf(i) != -1) {
                frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
                if (frequencyMap.get(i) > maxCount) {
                    maxCount = frequencyMap.get(i);
                    mostCommon = i;
                }
            }
        }

        return mostCommon == ' ' ? "No vowels found" : String.valueOf(mostCommon);
    }

// 10 задание

    public static void dataScience(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum += matrix[j][i];
                    count++;
                }
            }
            matrix[i][i] = sum / count;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}