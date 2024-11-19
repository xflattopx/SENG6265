package assignment06;

public class Factorial {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));  // Example: Output 120
        System.out.println(factorial(0));  // Example: Output 1
        System.out.println(factorial(3));  // Example: Output 6
    }
}

