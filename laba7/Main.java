public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // Вывод: 3
        System.out.println(stack.peek()); // Вывод: 2
        stack.push(4);
        System.out.println(stack.pop());  // Вывод: 4
    }
}
