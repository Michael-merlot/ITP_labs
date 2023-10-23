import java.util.LinkedList; // импорт класс LinkedList для пакета NumberFinder.java.util

public class HashTable<K, V> {
    private class Entry {
        K key; // ключ
        V value; // значение
        // имеет конструктор для иниц и методы для доступа к полям
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) { // метод для установки нового значения
            this.value = value; // устан новое значение
        }
    }

    private LinkedList<Entry>[] table; // массив связанных списков для хранения объектов типа Entry
    private int size; // для хранения кол-ва элементов в хэш

    public HashTable(int capacity) {
        table = new LinkedList[capacity]; // иниц массив table с заданной емкостью
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length; // вычислеяет и возвращает индекс ключа
    }

    public void put(K key, V value) {
        int index = hash(key); // вычисляет индекс для ключа
        if (table[index] == null) { // проверка, есть ли связанный список на этом индексе
            table[index] = new LinkedList<>(); // если нет - создаем новый список
        }

        for (Entry entry : table[index]) { // перебираем все элементы в списке этого индекса
            if (entry.getKey().equals(key)) { // есть такой ключ?
                entry.setValue(value); // если да - обновляем значение
                return;
            }
        }

        table[index].add(new Entry(key, value)); // добавляет новую пару "ключ-значение" в список
        size++;
    }

    public V get(K key) {
        int index = hash(key); // вычисляет индекс ключа
        if (table[index] != null) { // есть ли список на индексе
            for (Entry entry : table[index]) { // все элементы в списке
                if (entry.getKey().equals(key)) { // ищет ключ
                    return entry.getValue(); // если ключ найден
                }
            }
        }
        return null; // не найден
    }

    public V remove(K key) {
        int index = hash(key); // вычисляет индекс ключа
        if (table[index] != null) { // есть ли список на индексе
            for (Entry entry : table[index]) { // элементы в спике
                if (entry.getKey().equals(key)) { // ищет ключ
                    V value = entry.getValue(); // сохраняет тек значение
                    table[index].remove(entry); // удаляет пару ключ-значение
                    size--;
                    return value; // удаленное значение
                }
            }
        }
        return null; // если ключ не найден
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0; // true, если таблица пуста
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 7);

        System.out.println("Size after adding 3 elements: " + hashTable.size());
        System.out.println("Value for key 'apple': " + hashTable.get("apple"));
        System.out.println("Value for key 'banana': " + hashTable.get("banana"));
        System.out.println("Value for key 'orange': " + hashTable.get("orange"));

        System.out.println("Removed value for key 'apple': " + hashTable.remove("apple"));
        System.out.println("Size after removing 1 element: " + hashTable.size());

        System.out.println("Is hash table empty? " + hashTable.isEmpty());
    }
}
