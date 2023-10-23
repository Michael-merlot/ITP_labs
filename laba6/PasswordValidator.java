import java.util.regex.*; // работы с регулярными выражениями.

public class PasswordValidator {
    public static void main(String[] args) {
        String password = "Privet123";  // Замените на пароль, который нужно проверить

        // Регулярное выражение для проверки пароля
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) { // Метод matches() возвращает true, если пароль соответствует регулярному выражению.
            System.out.println("Valid password!");
        } else {
            System.out.println("Invalid password!");
        }
    }
}

// ^ и $ — начало и конец строки соответственно.
//(?=.*[A-Z]) — positive lookahead, который проверяет, есть ли хотя бы одна заглавная буква.
//(?=.*\\d) — positive lookahead, который проверяет, есть ли хотя бы одна цифра.
//[A-Za-z\\d]{8,16} — основное выражение, которое проверяет, что пароль состоит из 8-16 символов, включая латинские буквы и цифры.