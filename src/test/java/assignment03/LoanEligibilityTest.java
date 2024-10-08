package assignment03;

import org.junit.Assert;
import org.junit.Test;

public class LoanEligibilityTest {

    @Test
    public void testEligibilityApproved() {
        Assert.assertEquals("Approved", LoanEligibility.checkEligibility(20, 30000, 700, 10000));
    }

    @Test
    public void testEligibilityDeniedDueToAge() {
        Assert.assertEquals("Denied", LoanEligibility.checkEligibility(17, 30000, 700, 10000));
    }

    @Test
    public void testEligibilityDeniedDueToIncome() {
        Assert.assertEquals("Denied", LoanEligibility.checkEligibility(20, 20000, 700, 10000));
    }

    @Test
    public void testEligibilityDeniedDueToCreditScore() {
        Assert.assertEquals("Denied", LoanEligibility.checkEligibility(20, 30000, 500, 10000));
    }

    @Test
    public void testEligibilityDeniedDueToLoanAmount() {
        Assert.assertEquals("Denied", LoanEligibility.checkEligibility(20, 30000, 700, 20000));
    }

    @Test
    public void testEligibilityAtLowerBoundAge() {
        Assert.assertEquals("Approved", LoanEligibility.checkEligibility(18, 25000, 600, 12500));
    }

    @Test
    public void testEligibilityAtUpperBoundCreditScore() {
        Assert.assertEquals("Approved", LoanEligibility.checkEligibility(20, 30000, 850, 15000));
    }

    @Test
    public void testEligibilityInvalidAgeCheck() {
        Assert.assertEquals("Denied", LoanEligibility.checkEligibility(17, 25000, 700, 10000));
    }

    @Test
    public void testEligibilityInvalidIncomeCheck() {
        Assert.assertEquals("Denied", LoanEligibility.checkEligibility(20, 24999, 700, 10000));
    }

    @Test
    public void testEligibilityInvalidCreditScoreBelow() {
        Assert.assertEquals("Denied", LoanEligibility.checkEligibility(20, 30000, 599, 10000));
    }

    @Test
    public void testEligibilityInvalidCreditScoreAbove() {
        Assert.assertEquals("Denied", LoanEligibility.checkEligibility(20, 30000, 851, 10000));
    }

    @Test
    public void testEligibilityLoanAmountExceedsIncome() {
        Assert.assertEquals("Denied", LoanEligibility.checkEligibility(20, 30000, 700, 15001));
    }
}
