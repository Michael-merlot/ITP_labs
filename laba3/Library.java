public class Library extends Institution { // extends Institution указывает, что класс Library является подклассом класса Institution
    private int bookCount;
    private boolean hasStudyRooms; //bookCount хранит количество книг в библиотеке, а hasStudyRooms указывает, есть ли учебные комнаты.

    // Конструктор по умолчанию
    public Library() {
        super(); // super(); вызывает конструктор родительского класса Institution без параметров.
        this.bookCount = 0;
        this.hasStudyRooms = false;
    } // this.bookCount = 0; и this.hasStudyRooms = false; устанавливают значения по умолчанию для полей bookCount и hasStudyRooms

    // Конструктор с параметрами
    public Library(String name, String address, int capacity, int bookCount, boolean hasStudyRooms) {
        super(name, address, capacity); // вызывает конструктор родительского класса с переданными параметрами.
        this.bookCount = bookCount;
        this.hasStudyRooms = hasStudyRooms; // инициализируют поля переданными значениями
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
    @Override // аннотация указывает, что метод переопределяет метод родительского класса.
    public void displayInfo() { // аннотация указывает, что метод переопределяет метод родительского класса.
        System.out.println("Library Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Capacity: " + getCapacity());
        System.out.println("Book Count: " + bookCount);
        System.out.println("Has Study Rooms: " + (hasStudyRooms ? "Yes" : "No"));
    }
}
