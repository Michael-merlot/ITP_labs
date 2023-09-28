// Базовый абстрактный класс
abstract class Establishment {
    protected String name;
    protected String address;
    protected int capacity;
    private static int instanceCount = 0;

    public Establishment(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        instanceCount++;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    // Абстрактный метод
    public abstract void getInfo();

    // Счетчик созданных объектов
    public static int getInstanceCount() { return instanceCount; }
}

// Кафе
class Cafe extends Establishment {
    private String cuisine;

    public Cafe(String name, String address, int capacity, String cuisine) {
        super(name, address, capacity);
        this.cuisine = cuisine;
    }

    // Переопределение абстрактного метода
    public void getInfo() {
        System.out.println("Cafe: " + name + ", Address: " + address + ", Capacity: " + capacity + ", Cuisine: " + cuisine);
    }
}

// Магазин
class Shop extends Establishment {
    private String type;

    public Shop(String name, String address, int capacity, String type) {
        super(name, address, capacity);
        this.type = type;
    }

    // Переопределение абстрактного метода
    public void getInfo() {
        System.out.println("Shop: " + name + ", Address: " + address + ", Capacity: " + capacity + ", Type: " + type);
    }
}

// Библиотека
class Library extends Establishment {
    private int books;

    public Library(String name, String address, int capacity, int books) {
        super(name, address, capacity);
        this.books = books;
    }

    // Переопределение абстрактного метода
    public void getInfo() {
        System.out.println("Library: " + name + ", Address: " + address + ", Capacity: " + capacity + ", Books: " + books);
    }
}

public class Main {
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("CoffeeHouse", "Main St 123", 50, "Italian");
        Shop myShop = new Shop("GroceryMart", "Baker St 45", 30, "Grocery");
        Library myLibrary = new Library("Public Library", "Library St 6", 100, 5000);

        myCafe.getInfo();
        myShop.getInfo();
        myLibrary.getInfo();

        System.out.println("Total establishments: " + Establishment.getInstanceCount());
    }
}
