import java.util.Scanner;

public class FibonacciExample {

    // Recursive Fibonacci function
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci function
    public static void fibonacciIterative(int n) {
        int a = 0, b = 1, c;

        System.out.print("\nFibonacci Series (Iterative): ");
        if (n >= 1) System.out.print(a + " ");
        if (n >= 2) System.out.print(b + " ");

        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        // Iterative approach
        fibonacciIterative(n);

        // Recursive approach
        System.out.print("\nFibonacci Series (Recursive): ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }

        sc.close();
    }
}
