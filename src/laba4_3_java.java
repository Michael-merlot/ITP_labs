import java.util.Arrays;

public class laba4_3_java {
    public static void main(String[] args) {

        System.out.println(replaceVovels("apple") + "\n");
        System.out.println("---");

        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper") + "\n");
        System.out.println("---");

        System.out.println(doesBlockFit(1, 2, 3, 4, 5) ? "true" : "false");
        System.out.println(doesBlockFit(1, 8, 1, 1, 1) ? "true" : "false");
        System.out.println(doesBlockFit(1, 2, 2, 1, 1) ? "true" : "false" + "\n");
        System.out.println("---");

        System.out.println(numCheck(243));
        System.out.println(numCheck(52) + "\n");
        System.out.println("---");

        System.out.println(countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{2, 5, 2}));
        System.out.println(countRoots(new int[]{1, 5, 4}) + "\n");
        System.out.println("---");

        System.out.println(Arrays.toString(salesData(new String[][]{
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}})) + "\n");
        System.out.println("---");

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println(validSplit("cat Town") + "\n");
        System.out.println("---");

        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}) + "\n");
        System.out.println("---");

        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("aaaa eee o") + "\n");
        System.out.println("---");

        System.out.println(Arrays.deepToString(dataScience(new int[][]{
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}})).replace("], [", "],\n ["));
    }

    // Задание 1. создайте функцию, которая принимает строку и заменяет все гласные буквы на символ «*».

    public static String replaceVovels(String string) {
        String vowels = "[AEIOUaeiou]";

        String result = string.replaceAll(vowels, "*");

        return result; // *ppl*
    }

    // Задание 2. напишите функцию, которая принимает строку и заменяет две идущие подряд буквы по шаблону «Double*».

    public static String stringTransform(String string) {
        String zum = "(.)\\1"; // (.) - любой символ в стр, указывает 1 захватывающую группу (// для экранирования символа обратного слэша)

        String result = string.replaceAll(zum, "Double$1");

        return result; // heDoublelo, bDoubleoDoublekDoubleeper
    }

    /* Задание 3. помогите ребенку разобраться с игрушкой на развитие - поместится ли параллелепипед
     в коробку с отверстиями определенных параметров. Напишите функцию, которая принимает три
     измерения игрушечного блока:
     высоту(a), ширину(b) и глубину(c) и возвращает true, если этот блок может поместиться в отверстие с
     шириной(w)
     высотой(h).*/

    static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        int[] cub = {a, b, c}; // создание массивов для хранения размеров параллепипеда и отверстия
        int[] deep = {w, h};

        Arrays.sort(cub); // сортировка массивов
        Arrays.sort(deep);

        return cub[0] <= deep[0] && cub[1] <= deep[1]; // true, true, false
    }

    // проверка умещаются ли две наименьшие стороны пара в отверстие

    /* 4. Создайте функцию, которая принимает число в качестве входных данных и возвращает true,
    если сумма квадратов его цифр имеет ту же четность, что и само число. В противном случае верните false.*/

    public static boolean numCheck(int x) {
        int summKv = 0;
        int num; // для хранения каждой цифры х по очереди
        int origNum = x; // для хранения исходного значения, так как х изменяется в процессе работы

        while (x > 0) { //
            num = x % 10; // взятие ласт цифры числа
            summKv += num * num; // добавление квадрата цифры к сумме
            x /= 10; // удаление ласт цифры числа
        }
// сравнение остатков
        return summKv % 2 == origNum % 2; // true, false
    }

    /* 5. Создайте метод, который берет массив целых чисел-коэффициентов и возвращает количество
    целочисленных корней квадратного уравнения. */

    public static int countRoots(int[] coefficients) {
        int a = coefficients[0]; // извлечение коэф из массива
        int b = coefficients[1];
        int c = coefficients[2];

        int D = b * b - 4 * a * c;
        int intRootCount = 0; // используется для подсчета кол-ва корней

        if (D >= 0) {
            double x_1 = (-b + Math.sqrt(D)) / (2.0 * a);
            double x_2  = (-b - Math.sqrt(D)) / (2.0 * a);

            intRootCount += (int)x_1 == x_1 ? 1 : 0; // проверка является ли первый корень целым числом
            if (D > 0) {
                intRootCount += (int)x_2 == x_2 ? 1 : 0; // если диск положительный
            } // 1 : 0 if-else true - 1, false - 2
        }

        return intRootCount; // 2, 1, 2
    }

    /* 6. Создайте метод, который принимает двумерный массив, представляющий информацию
    о продажах разных товаров в различных магазинах, и возвращает товары, которые были
    проданы в каждом из магазинов. */

    public static String[] salesData(String[][] data) {
        int maxShop = 0; // хранит макс кол-во магазинов для товара
        for (String[] row : data) { // вычисляет макс кол-во магазинов для 1 товара
            if (row.length > maxShop) { // по всем строкам двумерного массива data
                maxShop = row.length; // row - кол-во элементов в стр
            }
        }
        int count = 0; // для подсчета кол-ва товаров
        String[] result = new String[data.length]; // результирующий массив
        for (String[] row : data) { // заполняет массив result товарами, продаются в maxShop магазинах
            if (row.length == maxShop) { // равно ли кол-во магазинов для тек товара
                result[count] = row[0]; // в стр тек товара адд в массив на позицию count
                count++;
            }
        }
        return Arrays.copyOf(result, count); // до размера count (надо для исключение неиниц элементы массива)
    }

    /* 7. Создайте функцию, которая определяет, можно ли разбить заданное предложение на слова так,
    чтобы каждое слово начиналось с последней буквы предыдущего слова. */

    public static boolean validSplit(String string) {
        String[] words = string.split(" "); // разбивает стр на слова по пробелам и сохраняет массив в вордс
        for (int i = 1; i < words.length; i++) { // по всем словам начиная со второго
            if (words[i].toLowerCase().charAt(0) != words[i-1].toLowerCase().charAt(words[i-1].length()-1))
                return false; /* начинается ли тек слово с той же буквы, на которую заканчивается пред слово.
                не выполняется - false*/
        }
        return true; // true, false, true
    }

    /* 8. Напишите метод, который определяет, является ли заданный массив «волнообразным».
    Последовательность чисел считается волнообразной, если разница между соседними элементами
    чередуется между убыванием и возрастанием. */

    public static boolean waveForm(int[] x) { // массив чисел
        if (x.length < 3) // необходимо 3 числа для образования последовательности
            return false;

        boolean increasing = x[1] > x[0]; // является ли тек пара чисел возрастающей
        for (int i = 2; i < x.length; i++) { // по всем эл массива начиная с 3
            if (increasing == (x[i] > x[i-1])) // проверяет образует тек пара чисел волновую послед с пред парой. нет - false/
                return false;
            increasing = !increasing; // обновление значения переменной
        }

        return true; // true, false, true
    }


    // 9. Напишите функцию, которая находит наиболее часто встречающуюся гласную в предложении.

    public static char commonVowel(String sentence) {
        String vowels = "aeiouAEIOU"; // список гласных букв
        int[] counts = new int[200]; // массив для подсчета кол-ва буквы.
        char commonVowel = ' '; // для хранения самой часто встреч гласной буквы

        for (char c : sentence.toCharArray()) { // по каждому символу в стр
            if (vowels.indexOf(c) != -1) { // явлеяется ли символ гласной
                int index = (int) c; // получение кода символа
                if (++counts[index] > counts[commonVowel]) { // увел счетчика для буквы и проверка стала ли она встр
                    commonVowel = c;
                }
            }
        }

        return commonVowel; // o, a
    }

    /* 10. Создайте функцию, которая принимает n целочисленных массивов длины n,
    а затем изменяет каждый n-ый элемент n-го массива на среднее арифметическое
    элементов n-го столбца остальных массивов. */

    public static int[][] dataScience(int[][] arrays) {
        int n = arrays.length; // получение размера массива
        for (int i = 0; i < n; i++) {
            int total = 0; // сумма всех элементов тек колоннны
            for (int k = 0; k < n; k++) {
                if (k != i) { // искл эл на главной диагонали из суммы
                    total += arrays[k][i]; // для суммирования всех эл в тек колонне
                }
            }
            arrays[i][i] = total / (n - 1); // вычисление ср ариф и запись его на главную диагональ
        }
        return arrays;
    }
}
