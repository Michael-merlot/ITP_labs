import java.io.FileInputStream; // для работы с файлами и исключениями вывод/ввод
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream inputStream = null; // для потоков ввод и вывод
        FileOutputStream outputStream = null;

        try { // чтение и запись файла
            inputStream = new FileInputStream("source.txt"); // чтение
            outputStream = new FileOutputStream("destination.txt"); // запись
            int byteData; // храненить прочитанные байты из файла

            while ((byteData = inputStream.read()) != -1) {
                // читать цикл по 1 байту пока read вернет -1
                outputStream.write(byteData); // запись байта в файл
            }
        } catch (IOException e) { // перехват исключения
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        } finally { // блок выполнится в любое случае, даже если будет искл
            try {
                if (inputStream != null) {
                    inputStream.close();
                } // закрытие потоком если они были открыты (не равны null)
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) { // при закрытии файлов
                System.out.println("Ошибка при закрытии файлов: " + e.getMessage());
            }
        }
    }
}
