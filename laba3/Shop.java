public class Shop extends Institution { // указывает, что класс Shop является подклассом класса Institution.
    private String type; // Поле type хранит тип магазина (например, продуктовый, одежды и т.д.),
    private boolean isOpenOnWeekends; // а isOpenOnWeekends указывает, открыт ли магазин по выходным.

    // Конструктор по умолчанию
    public Shop() {
        super();
        this.type = "Unknown";
        this.isOpenOnWeekends = false;
    } // устанавливают значения по умолчанию для полей type и isOpenOnWeekends.

    // Конструктор с параметрами
    public Shop(String name, String address, int capacity, String type, boolean isOpenOnWeekends) {
        super(name, address, capacity); // вызывает конструктор родительского класса с переданными параметрами.
        this.type = type;
        this.isOpenOnWeekends = isOpenOnWeekends; // инициализируют поля переданными значениями.
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
    @Override //  аннотация указывает, что метод переопределяет метод родительского класса.
    public void displayInfo() { //  это реализация абстрактного метода из родительского класса Institution.
        System.out.println("Shop Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Type: " + type);
        System.out.println("Is Open On Weekends: " + (isOpenOnWeekends ? "Yes" : "No"));
    }
}
