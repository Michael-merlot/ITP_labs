public abstract class Institution { // abstract указывает, что класс является абстрактным и не может быть инстанциирован напрямую.
    private static int instanceCount = 0; // Это статическое приватное поле, которое используется для подсчета количества созданных экземпляров класса Institution.
    private String name;
    private String address;
    private int capacity;
// name хранит имя заведения, address хранит адрес, и capacity хранит вместимость заведения.
    // Конструктор по умолчанию
    public Institution() {
        this("Unknown", "Unknown", 0); //вызывает конструктор с параметрами и устанавливает значения полей по умолчанию.
    }

    // Конструктор с параметрами
    public Institution(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity; // инициализируют поля переданными значениями.
        instanceCount++; //  увеличивает статический счетчик экземпляров на 1.
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
    public abstract void displayInfo(); // Это абстрактный метод, который должен быть переопределен в каждом неабстрактном подклассе.

    // Статический метод для получения количества созданных экземпляров
    public static int getInstanceCount() {
        return instanceCount; // Это статический метод, который возвращает текущее количество созданных экземпляров класса Institution.
    }
}
