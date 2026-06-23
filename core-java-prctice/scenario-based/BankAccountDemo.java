// Bank Account Management System

class BankAccount {

    // Instance Variables
    private String accountNumber;
    private String holderName;
    private double balance;

    // Static Variable to Track Total Accounts
    private static int totalAccountsCreated = 0;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        totalAccountsCreated++;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method with Overdraft Check
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Withdrawal failed! Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        }
    }

    // Account Statement Method
    public void getStatement() {
        System.out.println("\n----- Account Statement -----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Balance        : ₹" + balance);
        System.out.println("-----------------------------");
    }

    // Static Method
    public static int getTotalAccountsCreated() {
        return totalAccountsCreated;
    }
}

public class BankAccountDemo {

    public static void main(String[] args) {

        // Creating 3 Accounts
        BankAccount account1 = new BankAccount("ACC101", "Nishant", 10000);
        BankAccount account2 = new BankAccount("ACC102", "Rahul", 15000);
        BankAccount account3 = new BankAccount("ACC103", "Priya", 20000);

        // ===== Account 1 Transactions =====
        System.out.println("\nTransactions for Account 1");
        account1.deposit(2000);
        account1.withdraw(1500);
        account1.deposit(3000);
        account1.withdraw(5000);
        account1.withdraw(12000);

        // ===== Account 2 Transactions =====
        System.out.println("\nTransactions for Account 2");
        account2.deposit(5000);
        account2.withdraw(2000);
        account2.deposit(1500);
        account2.withdraw(4000);
        account2.withdraw(10000);

        // ===== Account 3 Transactions =====
        System.out.println("\nTransactions for Account 3");
        account3.deposit(7000);
        account3.withdraw(3000);
        account3.deposit(2500);
        account3.withdraw(10000);
        account3.withdraw(25000);

        // Print Statements
        account1.getStatement();
        account2.getStatement();
        account3.getStatement();

        // Display Total Accounts Created
        System.out.println("\nTotal Accounts Created: "
                + BankAccount.getTotalAccountsCreated());
    }
}