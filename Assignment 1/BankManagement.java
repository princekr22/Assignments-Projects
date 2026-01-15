import java.util.Scanner;

class BankManagement {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= 0 || amount > balance)
            throw new IllegalArgumentException();
        balance -= amount;
    }

    double getBalance() {
        return balance;
    }

    void displayAccountDetails() {
        System.out.println(accountNumber);
        System.out.println(accountHolder);
        System.out.println(balance);
    }
}

public class BankApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String accountNumber = sc.next();
        String accountHolder = sc.next();
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(accountNumber, accountHolder, initialBalance);

        while (true) {
            int choice = sc.nextInt();

            try {
                if (choice == 1) {
                    double amount = sc.nextDouble();
                    account.deposit(amount);
                } 
                else if (choice == 2) {
                    double amount = sc.nextDouble();
                    account.withdraw(amount);
                } 
                else if (choice == 3) {
                    System.out.println(account.getBalance());
                } 
                else if (choice == 4) {
                    account.displayAccountDetails();
                } 
                else if (choice == 5) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}
