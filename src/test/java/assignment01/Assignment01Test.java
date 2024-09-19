package assignment01;


import org.junit.Assert;
import org.junit.Test;

public class Assignment01Test {

    @Test
    public void bankAccountTest() {
        BankAccount account = new BankAccount("687890", 450.75);
        Assert.assertEquals("687890", account.getAccountNumber());
        Assert.assertEquals(450.75, account.getBalance(), 0.01);
    }

    @Test
    public void accountDetailsAccountNumberTest() {
        BankAccount account = new BankAccount("687890", 830.00);
        Assert.assertEquals("687890", account.getAccountNumber());
    }

    @Test
    public void accountDetailsAccountBalanceTest() {
        BankAccount account = new BankAccount("687890", 2150.50);
        Assert.assertEquals(2150.50, account.getBalance(), 0.01);
    }

    @Test
    public void accountDepositNegativeTest() {
        BankAccount account = new BankAccount("687890", 600.25);
        account.deposit(-300.00);
        Assert.assertEquals(600.25, account.getBalance(), 0.01);
    }

    @Test
    public void accountDepositZeroTest() {
        BankAccount account = new BankAccount("687890", 1000.00);
        account.deposit(0.0);
        Assert.assertEquals(1000.00, account.getBalance(), 0.01);
    }

    @Test
    public void accountWithdrawalNegativeWithdrawalTest() {
        BankAccount account = new BankAccount("687890", 750.00);
        account.withdraw(-50.00);
        Assert.assertEquals(750.00, account.getBalance(), 0.01);
    }

    @Test
    public void accountWithdrawalOverdraftTest() {
        BankAccount account = new BankAccount("687890", 920.00);
        account.withdraw(1200.00);
        Assert.assertEquals(920.00, account.getBalance(), 0.01);
    }

    @Test
    public void accountWithdrawalLimitTest() {
        BankAccount account = new BankAccount("687890", 300.00);
        account.withdraw(100.00);
        Assert.assertEquals(200.00, account.getBalance(), 0.01);
    }

    @Test
    public void accountTransactionTestDeposit() {
        BankAccount account = new BankAccount("687890", 800.00);
        account.deposit(250.00);
        Assert.assertEquals(1050.00, account.getBalance(), 0.01);
    }

    @Test
    public void accountTransactionWithdrawalTest() {
        BankAccount account = new BankAccount("687890", 500.00);
        account.withdraw(150.00);
        Assert.assertEquals(350.00, account.getBalance(), 0.01);
    }

    @Test
    public void accountErrorHandlingBalanceBelowZeroTest() {
        BankAccount account = new BankAccount("687890", 500.00);
        account.withdraw(500.00);
        account.withdraw(1.00); // Attempt to overdraw
        Assert.assertEquals(0.00, account.getBalance(), 0.01);
    }
}

