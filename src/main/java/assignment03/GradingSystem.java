package assignment03;

public class GradingSystem {

    public static String getGrade(int score) {
        if (score < 0 || score > 100) {
            return "Invalid score";
        } else if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    public static void main(String[] args) {
        System.out.println(getGrade(95)); // A
        System.out.println(getGrade(85)); // B
        System.out.println(getGrade(73)); // C
        System.out.println(getGrade(60)); // D
        System.out.println(getGrade(59)); // F
        System.out.println(getGrade(-5)); // Invalid score
    }
}
