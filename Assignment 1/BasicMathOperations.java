import java.util.Scanner;

public class BasicMathOperations {

    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        return a / b;
    }

    static int remainder(int a, int b) {
        return a % b;
    }

    static int square(int a) {
        return a * a;
    }

    static int cube(int a) {
        return a * a * a;
    }

    static int absolute(int a) {
        return a < 0 ? -a : a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(add(x, y));
        System.out.println(subtract(x, y));
        System.out.println(multiply(x, y));
        System.out.println(divide(x, y));
        System.out.println(remainder(x, y));
        System.out.println(square(x));
        System.out.println(cube(x));
        System.out.println(absolute(x));

        sc.close();
    }
}

