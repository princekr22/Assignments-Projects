import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexInputValidation {

    static boolean validateMobile(String mobile) {
        return Pattern.matches("[6-9][0-9]{9}", mobile);
    }

    static boolean validateEmail(String email) {
        return Pattern.matches("[a-zA-Z0-9._]+@[a-zA-Z]+\\.[a-zA-Z]{2,}", email);
    }

    static boolean validateUsername(String username) {
        return Pattern.matches("[a-zA-Z][a-zA-Z0-9_]{4,15}", username);
    }

    static boolean validatePassword(String password) {
        return Pattern.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{6,}", password);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                if (choice == 1) {
                    String mobile = sc.nextLine();
                    System.out.println(validateMobile(mobile) ? "Welcome" : "Invalid input");
                } 
                else if (choice == 2) {
                    String email = sc.nextLine();
                    System.out.println(validateEmail(email) ? "Welcome" : "Invalid input");
                } 
                else if (choice == 3) {
                    String username = sc.nextLine();
                    System.out.println(validateUsername(username) ? "Welcome" : "Invalid input");
                } 
                else if (choice == 4) {
                    String password = sc.nextLine();
                    System.out.println(validatePassword(password) ? "Welcome" : "Invalid input");
                } 
                else if (choice == 5) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }

        sc.close();
    }
}
