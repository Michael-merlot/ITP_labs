public abstract class Institution {
    private static int instanceCount = 0; // статическая переменная для подсчета экземпляров
    private String name;
    private String address;
    private int capacity;

    // Конструктор по умолчанию
    public Institution() {
        this("Unknown", "Unknown", 0);
    }

    // Конструктор с параметрами
    public Institution(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        instanceCount++;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Абстрактный метод для вывода информации о заведении
    public abstract void displayInfo();

    // Статический метод для получения количества созданных экземпляров
    public static int getInstanceCount() {
        return instanceCount;
    }
}
