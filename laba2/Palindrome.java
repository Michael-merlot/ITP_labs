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

    // Метод для переворачивания строки
    public static String reverseString(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i); // Добавляем символы в обратном порядке
        }
        return reverse;
    }

    // Метод для проверки палиндрома
    public static boolean isPalindrome(String s) {
        String reversed = reverseString(s);
        return s.equals(reversed); // Сравниваем исходную и перевернутую строку
    }
}
