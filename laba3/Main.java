public class Main { // name, address, capacity, cuisine, HasWifi
    public static void main(String[] args) { //  С помощью оператора new, мы создаем новый экземпляр (объект) класса Cafe.
        Cafe cafe = new Cafe("Starbucks", "123 Main St", 50, "American", true);
        Shop shop = new Shop("Walmart", "456 Elm St", 200, "Grocery", true);
        Library library = new Library("Public Library", "789 Oak St", 100, 5000, true);

        cafe.displayInfo(); // Этот метод вызывается для объекта cafe и выводит информацию о кафе.
        shop.displayInfo();
        library.displayInfo();

        System.out.println("Total institutions: " + Institution.getInstanceCount());
    } // Этот метод выводит общее количество созданных объектов, используя статический метод getInstanceCount() из класса Institution.
}
