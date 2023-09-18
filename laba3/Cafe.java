public class Cafe extends Institution {
    private String cuisine;
    private boolean hasWiFi;

    // Конструктор по умолчанию
    public Cafe() {
        super();
        this.cuisine = "Unknown";
        this.hasWiFi = false;
    }

    // Конструктор с параметрами
    public Cafe(String name, String address, int capacity, String cuisine, boolean hasWiFi) {
        super(name, address, capacity);
        this.cuisine = cuisine;
        this.hasWiFi = hasWiFi;
    }

    // Геттеры и сеттеры
    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public boolean isHasWiFi() {
        return hasWiFi;
    }

    public void setHasWiFi(boolean hasWiFi) {
        this.hasWiFi = hasWiFi;
    }

    // Переопределенный метод для вывода информации о кафе
    @Override
    public void displayInfo() {
        System.out.println("Cafe Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Has WiFi: " + (hasWiFi ? "Yes" : "No"));
    }
}
