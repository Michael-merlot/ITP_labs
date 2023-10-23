import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StoreSales {
    private Set<String> uniqueProducts;
    private Map<String, Integer> productSales;
    private int totalSales;
    private String mostPopularProduct;

    public StoreSales() {
        uniqueProducts = new HashSet<>();
        productSales = new HashMap<>();
        totalSales = 0;
        mostPopularProduct = null;
    }

    public void addSale(String product, int price) {
        uniqueProducts.add(product);
        totalSales += price;

        productSales.put(product, productSales.getOrDefault(product, 0) + 1);

        if (mostPopularProduct == null ||
                productSales.get(product) > productSales.get(mostPopularProduct)) {
            mostPopularProduct = product;
        }
    }

    public void displaySales() {
        System.out.println("List of unique sold products:");
        for (String product : uniqueProducts) {
            System.out.println(product);
        }

        System.out.println("Total sales amount: $" + totalSales);

        System.out.println("Most popular product: " + mostPopularProduct);
    }

    public static void main(String[] args) {
        StoreSales store = new StoreSales();
        store.addSale("Apple", 150);
        store.addSale("Banana", 100);
        store.addSale("Apple", 150);
        store.addSale("Orange", 200);
        store.addSale("Banana", 100);

        store.displaySales();
    }
}
//- uniqueProducts — HashSet, хранящий уникальные проданные товары.
//- productSales — HashMap, хранящий проданные товары и количество их продаж.
//- totalSales — общая сумма продаж.
//- mostPopularProduct — наиболее популярный проданный товар.
//Методы:
//- addSale(String product, int price) — добавляет проданный товар и его цену.
//- displaySales() — выводит список уникальных проданных товаров, общую сумму продаж и наиболее популярный товар.