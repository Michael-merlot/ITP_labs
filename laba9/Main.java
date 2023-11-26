import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// аннотации, отражение, коллекции и классы для многопоточности

// Аннотация DataProcessor
@Retention(RetentionPolicy.RUNTIME) // аннотация будет доступна во время выполнения программы.
@Target(ElementType.METHOD) // аннотацию можно применять только к методам.
@interface DataProcessor { // опциональный элемент, который можно использовать для добавления описания к методу.
    String description() default "";
}

// Класс DataManager
class DataManager { // создаёт список объектов, которые будут использоваться для обработки данных.
    private List<Object> processors = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor); // метод для регистрации обработчиков данных и добавляет переданный объект в список processors.
    }

    public void loadData(String source) {
        // Загрузка данных
        System.out.println("Loading data from " + source); // метод для имитации загрузки данных из источника.
    }

    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    executorService.submit(() -> {
                        try {
                            method.invoke(processor);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }
// создаёт пул потоков с 5 рабочими потоками и затем итерирует по списку processors, чтобы найти и выполнить методы, аннотированные как @DataProcessor.
        executorService.shutdown();
    }

    public void saveData(String destination) { // для сохранения обработанных данных в новый источник
        // Сохранение данных
        System.out.println("Saving data to " + destination);
    }
}

// Классы обработчиков данных. Эти классы содержат методы, которые аннотированы @DataProcessor.
// Эти методы будут вызываться многопоточно для обработки данных.
class DataFilter {
    @DataProcessor(description = "Filter data")
    public void filter() {
        System.out.println("Filtering data");
    }
}

class DataTransformer {
    @DataProcessor(description = "Transform data")
    public void transform() {
        System.out.println("Transforming data");
    }
}

class DataAggregator {
    @DataProcessor(description = "Aggregate data")
    public void aggregate() {
        System.out.println("Aggregating data");
    }
}

// Главный класс для тестирования
public class Main { // создаёт экземпляр DataManager, регистрирует обработчики, загружает данные, обрабатывает и сохраняет их.
    public static void main(String[] args) {
        DataManager manager = new DataManager();

        manager.registerDataProcessor(new DataFilter());
        manager.registerDataProcessor(new DataTransformer());
        manager.registerDataProcessor(new DataAggregator());

        manager.loadData("source.txt");
        manager.processData();
        manager.saveData("destination.txt");
    }
}
