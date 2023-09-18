public class Cafe extends Institution { // указывает, что класс Cafe является подклассом класса Institution.
    private String cuisine;
    private boolean hasWiFi;
// Поле cuisine хранит тип кухни (например, итальянская, японская и т.д.), а hasWiFi указывает, есть ли Wi-Fi в кафе.
    // Конструктор по умолчанию
    public Cafe() {
        super(); //  вызывает конструктор родительского класса Institution без параметров.
        this.cuisine = "Unknown";
        this.hasWiFi = false;
    } // устанавливают значения по умолчанию для полей cuisine и hasWiFi.

    // Конструктор с параметрами
    public Cafe(String name, String address, int capacity, String cuisine, boolean hasWiFi) {
        super(name, address, capacity); //  вызывает конструктор родительского класса с переданными параметрами.
        this.cuisine = cuisine;
        this.hasWiFi = hasWiFi;
    }// инициализируют поля переданными значениями.

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
    @Override // аннотация указывает, что метод переопределяет метод родительского класса.
    public void displayInfo() { // это реализация абстрактного метода из родительского класса Institution.
        System.out.println("Cafe Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Has WiFi: " + (hasWiFi ? "Yes" : "No"));
    }
}
