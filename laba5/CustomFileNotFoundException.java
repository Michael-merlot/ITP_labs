import java.io.FileNotFoundException; // класс мог расширять этот тип искл

public class CustomFileNotFoundException extends FileNotFoundException { // 1 становится подтипом искл 2
    public CustomFileNotFoundException(String message) { // конструктор с помощью get.Message
        super(message); // вызов конструктора FNFE
    }
}
