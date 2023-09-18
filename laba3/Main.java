public class Main {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Starbucks", "123 Main St", 50, "American", true);
        Shop shop = new Shop("Walmart", "456 Elm St", 200, "Grocery", true);
        Library library = new Library("Public Library", "789 Oak St", 100, 5000, true);

        cafe.displayInfo();
        shop.displayInfo();
        library.displayInfo();

        System.out.println("Total institutions: " + Institution.getInstanceCount());
    }
}
