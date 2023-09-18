public class Library extends Institution {
    private int bookCount;
    private boolean hasStudyRooms;

    // Конструктор по умолчанию
    public Library() {
        super();
        this.bookCount = 0;
        this.hasStudyRooms = false;
    }

    // Конструктор с параметрами
    public Library(String name, String address, int capacity, int bookCount, boolean hasStudyRooms) {
        super(name, address, capacity);
        this.bookCount = bookCount;
        this.hasStudyRooms = hasStudyRooms;
    }

    // Геттеры и сеттеры
    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public boolean isHasStudyRooms() {
        return hasStudyRooms;
    }

    public void setHasStudyRooms(boolean hasStudyRooms) {
        this.hasStudyRooms = hasStudyRooms;
    }

    // Переопределенный метод для вывода информации о библиотеке
    @Override
    public void displayInfo() {
        System.out.println("Library Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Book Count: " + bookCount);
        System.out.println("Has Study Rooms: " + (hasStudyRooms ? "Yes" : "No"));
    }
}
