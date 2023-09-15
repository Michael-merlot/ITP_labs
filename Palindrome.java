public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " is a palindrome");
            } else {
                System.out.println(s + " is not a palindrome");
            }
        }
    }
    // Массивы с 0 и кол-во элементов в массиве args
    // Внутри цикла каждый элемент сохраняется в s для обработки
    public static String reverseString(String s) {
        String reversed = ""; // склеивание
        for (int i = s.length() - 1; i >= 0; i--) { // Переборка символов в строке s
            reversed += s.charAt(i); // Метод для извлечения символа из строки с индексом i
        } // charAt - извлекает символ у строки
        return reversed; // Принимает строку s и возвращает обратно
    }

    public static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }
} // java Palindrome madam racecar apple kayak song noon

