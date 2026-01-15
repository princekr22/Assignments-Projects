import java.io.*;
import java.util.Scanner;

abstract class Account {

    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    double getBalance() {
        return balance;
    }

    void displayDetails() {
        System.out.println(accountNumber);
        System.out.println(accountHolder);
        System.out.println(balance);
    }
}

class SavingsAccount extends Account {

    SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
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
}

class CurrentAccount extends Account {

    CurrentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance -= amount;
    }
}

class FileManager {

    static void saveAccount(Account account) throws IOException {
        FileWriter writer = new FileWriter("accounts.txt", true);
        writer.write(account.accountNumber + "," +
                     account.accountHolder + "," +
                     account.balance + "\n");
        writer.close();
    }

    static void displayAllAccounts() throws IOException {
        File file = new File("accounts.txt");
        if (!file.exists())
            return;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            System.out.println(data[0] + " " + data[1] + " " + data[2]);
        }
        reader.close();
    }
}

public class BankManagementSystemFile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account account = null;

        try {
            String accNo = sc.next();
            String name = sc.next();
            double balance = sc.nextDouble();
            int type = sc.nextInt();

            if (type == 1)
                account = new SavingsAccount(accNo, name, balance);
            else
                account = new CurrentAccount(accNo, name, balance);

            FileManager.saveAccount(account);

            while (true) {
                int choice = sc.nextInt();

                try {
                    if (choice == 1) {
                        double amt = sc.nextDouble();
                        account.deposit(amt);
                        FileManager.saveAccount(account);
                    } 
                    else if (choice == 2) {
                        double amt = sc.nextDouble();
                        account.withdraw(amt);
                        FileManager.saveAccount(account);
                    } 
                    else if (choice == 3) {
                        System.out.println(account.getBalance());
                    } 
                    else if (choice == 4) {
                        account.displayDetails();
                    } 
                    else if (choice == 5) {
                        FileManager.displayAllAccounts();
                    } 
                    else if (choice == 6) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid transaction");
                }
            }

        } catch (Exception e) {
            System.out.println("Error occurred");
        }

        sc.close();
    }
}
