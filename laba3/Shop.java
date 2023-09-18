public class Shop extends Institution {
    private String type;
    private boolean isOpenOnWeekends;

    // Конструктор по умолчанию
    public Shop() {
        super();
        this.type = "Unknown";
        this.isOpenOnWeekends = false;
    }

    // Конструктор с параметрами
    public Shop(String name, String address, int capacity, String type, boolean isOpenOnWeekends) {
        super(name, address, capacity);
        this.type = type;
        this.isOpenOnWeekends = isOpenOnWeekends;
    }

    // Геттеры и сеттеры
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOpenOnWeekends() {
        return isOpenOnWeekends;
    }

    public void setOpenOnWeekends(boolean openOnWeekends) {
        isOpenOnWeekends = openOnWeekends;
    }

    // Переопределенный метод для вывода информации о магазине
    @Override
    public void displayInfo() {
        System.out.println("Shop Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Type: " + type);
        System.out.println("Is Open On Weekends: " + (isOpenOnWeekends ? "Yes" : "No"));
    }
}
