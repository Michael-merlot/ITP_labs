public class Main {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Starbucks", "123 Main St", 50, "American", true);
        Shop shop = new Shop("Walmart", "456 Elm St", 200, "Grocery", true);
        Library library = new Library("Public Library", "789 Oak St", 100, 5000, true);
// Здесь создается новый объект класса Cafe с именем cafe и инициализируется его поля.
// Здесь создается новый объект класса Shop с именем shop и инициализируется его поля.
// Здесь создается новый объект класса Library с именем library и инициализируется его поля.
        cafe.displayInfo(); // Этот метод вызывается для объекта cafe и выводит информацию о кафе.
        shop.displayInfo(); // выводит информацию о магазине.
        library.displayInfo(); // выводит информацию о библиотеке.

        System.out.println("Total institutions: " + Institution.getInstanceCount());
    } // Этот метод выводит общее количество созданных объектов, используя статический метод getInstanceCount() из класса Institution.
}
