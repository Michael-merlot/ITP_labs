import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainProgram {
    public static void main(String[] args) {
        File file = new File("non_existent_file.txt");
        // создание объекта file для файла
        try { // чтение файла
            if (!file.exists()) { // проверка на существование файла
                throw new CustomFileNotFoundException("Файл не найден: " + file.getName());
            } // если файла нет, то выбрасывается исключение

            FileInputStream fis = new FileInputStream(file); // для чтения из файла
            fis.close(); // закрытие потока чтения файла
        } catch (CustomFileNotFoundException e) { // перехват исключения
            System.out.println(e.getMessage());
            logException(e); // для логирования искл
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
            logException(e);
        }
    }

    public static void logException(Exception e) { // принимает искл как аргумент
        System.out.println("Исключение залогировано: " + e.getMessage());
    }
}
