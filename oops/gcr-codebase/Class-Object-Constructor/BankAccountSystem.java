class BankAccount {
    private int accountNumber;
    private String holder;
    private double balance;

    static int totalAccounts = 0;

    public BankAccount(int accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(holder + " deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(holder + " withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient Balance for " + holder);
        }
    }

    public void getStatement() {
        System.out.println("\nAccount Number : " + accountNumber);
        System.out.println("Holder Name    : " + holder);
        System.out.println("Balance        : ₹" + balance);
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {

        BankAccount a1 = new BankAccount(101, "Mayank", 10000);
        BankAccount a2 = new BankAccount(102, "Ravi", 15000);
        BankAccount a3 = new BankAccount(103, "Aman", 20000);

        a1.deposit(1000);
        a1.withdraw(500);
        a1.deposit(2000);
        a1.withdraw(3000);
        a1.withdraw(1000);

        a2.deposit(5000);
        a2.withdraw(1000);
        a2.deposit(1500);
        a2.withdraw(7000);
        a2.deposit(1000);

        a3.deposit(3000);
        a3.withdraw(2000);
        a3.deposit(4000);
        a3.withdraw(1000);
        a3.withdraw(500);

        a1.getStatement();
        a2.getStatement();
        a3.getStatement();

        System.out.println("\nTotal Accounts Created: " + BankAccount.totalAccounts);
    }
}