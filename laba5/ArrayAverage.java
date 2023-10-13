public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // массив чисел и 5 элементов
        double sum = 0; // хранения суммы элементов массива
        double average = 0; // хранения ср ариф

        try { // обработка массива (может возникнуть исключение)
            for (int i = 0; i <= arr.length; i++) { // Добавим ошибку: i <= arr.length (к выходу за границы)
                sum += arr[i]; // add тек элемента массива к sum
            }
            average = sum / arr.length; // вычисление ср ариф деления суммы на кол-во элементов
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) { // catch - для обработки исключений в блоке try
            System.out.println("Ошибка: выход за границы массива");
        } catch (NumberFormatException e) { // e - переменная, будет сохранено исключение для дальн использования
            System.out.println("Ошибка: неверный формат числа");
        }
    }
}
