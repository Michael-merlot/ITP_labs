import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Warehouse {
    private int totalWeight;
    private final Lock lock;
    private final Condition condition;

    public Warehouse() {
        this.totalWeight = 0;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void addWeight(int weight) {
        lock.lock();
        try {
            while (totalWeight + weight > 150) {
                condition.await();
            }
            totalWeight += weight;
            System.out.println("Added " + weight + " kg. Total weight: " + totalWeight + " kg.");
            if (totalWeight >= 150) {
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void unload() {
        lock.lock();
        try {
            while (totalWeight < 150) {
                condition.await();
            }
            System.out.println("Unloading 150 kg.");
            totalWeight -= 150;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Thread loader1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                warehouse.addWeight(30);
            }
        });

        Thread loader2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                warehouse.addWeight(20);
            }
        });

        Thread loader3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                warehouse.addWeight(25);
            }
        });

        Thread unloader = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                warehouse.unload();
            }
        });

        loader1.start();
        loader2.start();
        loader3.start();
        unloader.start();
    }
}
// Класс Warehouse содержит методы addWeight и unload, которые синхронизированы с помощью Lock и Condition.
//Метод addWeight добавляет вес к totalWeight и ждет, если добавление веса приведет к превышению лимита в 150 кг.
//Метод unload уменьшает totalWeight на 150 кг и освобождает условие, чтобы другие потоки могли продолжить добавление веса.
//В main методе создаются 3 потока-грузчика и один поток-разгрузчик, которые выполняют соответствующие операции.