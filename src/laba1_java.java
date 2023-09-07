public class laba1_java {
    public static void main(String[] args) {
        System.out.println(convert(5)); // 18.925
        System.out.println(convert(3)); // 11.355
        System.out.println(convert(8)); // 30.28

        System.out.println(fitCalc(15, 1));  // 15
        System.out.println(fitCalc(24, 2));  // 48
        System.out.println(fitCalc(41, 3));  // 123

        System.out.println(containers(3, 4, 2));  // 460
        System.out.println(containers(5, 0, 2));  // 300
        System.out.println(containers(4, 1, 4));  // 530

        System.out.println(triangleType(5, 5, 5)); // equilateral
        System.out.println(triangleType(5, 4, 5)); // isosceles
        System.out.println(triangleType(3, 4, 5)); // different-sided
        System.out.println(triangleType(5, 1, 1)); // not a triangle

        System.out.println(ternaryEvaluation(8, 4));  // 8
        System.out.println(ternaryEvaluation(1, 11)); // 11
        System.out.println(ternaryEvaluation(5, 9));  // 9

        System.out.println(howManyItems(22, 1.4, 2));  // 3
        System.out.println(howManyItems(45, 1.8, 1.9)); // 6
        System.out.println(howManyItems(100, 2, 2));  // 12

        System.out.println(factorial(3));  // 6
        System.out.println(factorial(5));  // 120
        System.out.println(factorial(7));  // 5040

        System.out.println(gcd(48, 18));  // 6
        System.out.println(gcd(52, 8));   // 4
        System.out.println(gcd(259, 28)); // 7

        System.out.println(ticketSaler(70, 1500));  // 75600
        System.out.println(ticketSaler(24, 950));   // 16416
        System.out.println(ticketSaler(53, 1250));  // 47700

        System.out.println(tables(5, 2));  // 1
        System.out.println(tables(31, 20));  // 0
        System.out.println(tables(123, 58));  // 4
    }

// 1 задание

    public static float convert(int x) {
        return x * 3.785f;
    }

// 2 задание

    public static int fitCalc(int minutes, int intensity) {
        return minutes * intensity;
    }

// 3 задание

    public static int containers(int boxes, int bags, int barrels) {
        return boxes * 20 + bags * 50 + barrels * 100;
    }


// 4 задание

    public static String triangleType(int x, int y, int z) {

        if (x + y <= z || x + z <= y || y + z <= x) {
            return "not a triangle";
        } else if (x == y && y == z) {
            return "equilateral";
        } else if (x == y || y == z || x == z) {
            return "isosceles";
        } else {
            return "different-sided";
        }
    }

// 5 задание

    public static int ternaryEvaluation(int a, int b) {
        return a > b ? a : b;
    }

// 6 задание

    public static int howManyItems(double n, double w, double h) {
        double fabricRequiredForOneItem = w * h * 2;
        int maxItems = (int) (n / fabricRequiredForOneItem);
        return maxItems;
    }

// 7 задание

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

// 8 задание

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

// 9 задание

    public static int ticketSaler(int tickets, int price) {
        double commissionRate = 0.72;
        return (int) (tickets * price * commissionRate);
    }

// 10 задание

    public static int tables(int students, int tablesAvailable) {
        int tablesRequired = (students + 1) / 2;
        int tablesNeeded = tablesRequired - tablesAvailable;

        return Math.max(tablesNeeded, 0);
    }
}
