import java.util.LinkedList;
import java.util.List;

public class OrderHashTable {
    private class Entry { // для хранение ключ-значение
        int key; // для хранения клшюча (номер заказа)
        Order value; // информация о заказе

        public Entry(int key, Order value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table;
    private int size; // хранение тек кол-ва элементов в хэш

    public OrderHashTable(int capacity) { //иниц массива table и поле size
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(int key) { // метод для вычисления хэша ключа
        return Math.abs(Integer.hashCode(key)) % table.length; // вычисляем хэш по модулю длины массива
    }

    public void put(int key, Order value) { // добавление элемента в хэш
        int index = hash(key);
        if (table[index] == null) { // есть ли список по индексу
            table[index] = new LinkedList<>(); // нет его - то создаем
        }
        for (Entry entry : table[index]) { // элементам списка находящ по индексу
            if (entry.key == key) { // с таким же ключом?
                entry.value = value; // да - обновляем
                return;
            }
        }
        table[index].add(new Entry(key, value)); // не найден - добавляем ключ-значение в список
        size++;
    }

    public Order get(int key) { // для получения по ключу
        int index = hash(key);
        if (table[index] != null) { // есть ли список по индексу?
            for (Entry entry : table[index]) {
                if (entry.key == key) { // совпадает
                    return entry.value;
                }
            }
        }
        return null;
    }

    public Order remove(int key) { // удаления
        int index = hash(key);
        if (table[index] != null) {
            for (Entry entry : table[index]) {
                if (entry.key == key) {
                    Order value = entry.value;
                    table[index].remove(entry);
                    size--;
                    return value;
                }
            }
        }
        return null;
    }

    public void updateStatus(int key, String newStatus) { // обновление статуса
        Order order = get(key); // ищет в хэш заказ с указанным ключом
        if (order != null) { // не равен - заказ есть
            order.setStatus(newStatus);
        }
    }

    public int size() { // размер хэш
        return size;
    }

    public boolean isEmpty() { // пустой ли хэш
        return size == 0;
    }
}
