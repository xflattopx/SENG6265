package assignment03;

public class TriangleClassifier {

    public static String classifyTriangle(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Not a triangle";
        } else if (a == b && b == c) {
            return "Equilateral";
        } else if (a == b || b == c || a == c) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    public static void main(String[] args) {
        System.out.println(classifyTriangle(3, 3, 3)); // Equilateral
        System.out.println(classifyTriangle(3, 4, 5)); // Scalene
        System.out.println(classifyTriangle(3, 3, 5)); // Isosceles
        System.out.println(classifyTriangle(1, 2, 3)); // Not a triangle
    }
}
