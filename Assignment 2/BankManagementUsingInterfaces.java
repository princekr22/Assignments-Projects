import java.util.Scanner;

interface BankingOperations {
    void depositAmount(double amount);
    void withdrawAmount(double amount);
    double checkBalance();
}

interface CustomerOperations {
    void displayCustomerDetails();
}

class BankAccount implements BankingOperations, CustomerOperations {

    private String accountNumber;
    private String customerName;
    private double balance;

    BankAccount(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public void depositAmount(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance += amount;
    }

    public void withdrawAmount(double amount) {
        if (amount <= 0 || amount > balance)
            throw new IllegalArgumentException();
        balance -= amount;
    }

    public double checkBalance() {
        return balance;
    }

    public void displayCustomerDetails() {
        System.out.println(accountNumber);
        System.out.println(customerName);
        System.out.println(balance);
    }
}

public class BankManagementUsingInterfaces {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String accountNumber = sc.next();
        String customerName = sc.next();
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(accountNumber, customerName, initialBalance);

        while (true) {
            int choice = sc.nextInt();

            try {
                if (choice == 1) {
                    double amount = sc.nextDouble();
                    account.depositAmount(amount);
                } 
                else if (choice == 2) {
                    double amount = sc.nextDouble();
                    account.withdrawAmount(amount);
                } 
                else if (choice == 3) {
                    System.out.println(account.checkBalance());
                } 
                else if (choice == 4) {
                    account.displayCustomerDetails();
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
