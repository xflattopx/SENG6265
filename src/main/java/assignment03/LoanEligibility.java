package assignment03;

public class LoanEligibility {
    public static String checkEligibility(int age, double income, int creditScore, double loanAmount) {
        if (age < 18 || income < 25000 || creditScore < 600 || creditScore > 850 || loanAmount > (income *
                0.5)) {
            return "Denied";
        }
        return "Approved";
    }
    public static void main(String[] args) {
        System.out.println(checkEligibility(20, 30000, 700, 10000)); // Approved
        System.out.println(checkEligibility(17, 30000, 700, 10000)); // Denied (age)
        System.out.println(checkEligibility(20, 20000, 700, 10000)); // Denied (income)
        System.out.println(checkEligibility(20, 30000, 500, 10000)); // Denied (credit score)
        System.out.println(checkEligibility(20, 30000, 700, 20000)); // Denied (loan amount)
    }
}
