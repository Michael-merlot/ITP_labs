import java.util.Arrays; // массив
import java.util.List; // список

public class Order {
    private String orderDate; // дата заказа
    private List<String> items; // списки
    private String status; //

    public Order(String orderDate, List<String> items, String status) {
        this.orderDate = orderDate;
        this.items = items;
        this.status = status;
    }
// нужны для приватных полей (геттеры и сеттеры)
    public String getOrderDate() {
        return orderDate;
    }

    public List<String> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void main(String[] args) {
        // Создаем объекты класса Order
        Order order1 = new Order("2023-10-10", Arrays.asList("Laptop", "Mouse"), "Shipped");
        Order order2 = new Order("2023-10-11", Arrays.asList("Book", "Pen"), "Pending");

        // Создаем хеш-таблицу с начальной емкостью 10
        OrderHashTable hashTable = new OrderHashTable(10);

        // Добавляем заказы в хеш-таблицу
        hashTable.put(1, order1);
        hashTable.put(2, order2);

        // Получаем и выводим заказы из хеш-таблицы
        System.out.println("Order 1 status: " + hashTable.get(1).getStatus());
        System.out.println("Order 2 status: " + hashTable.get(2).getStatus());

        // Обновляем статус заказа
        hashTable.updateStatus(1, "Delivered"); // первый заказ

        // Проверяем обновленный статус
        System.out.println("Updated Order 1 status: " + hashTable.get(1).getStatus()); // первы1 заказ

        // Удаляем заказ из хеш-таблицы
        hashTable.remove(2);

        // Проверяем размер хеш-таблицы
        System.out.println("Hash table size: " + hashTable.size());
    }
}
