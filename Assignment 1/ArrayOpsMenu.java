import java.util.Scanner;

public class ArrayOpsMenu {

    static void insert(int[] a, int n, int pos, int val) {
        for (int i = n; i > pos; i--) {
            a[i] = a[i - 1];
        }
        a[pos] = val;
    }

    static void delete(int[] a, int n, int pos) {
        for (int i = pos; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
    }

    static int linearSearch(int[] a, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (a[i] == key)
                return i;
        }
        return -1;
    }

    static int binarySearch(int[] a, int n, int key) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key)
                return mid;
            if (a[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    static int maxValue(int[] a, int n) {
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    static void countEvenOdd(int[] a, int n) {
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println(even);
        System.out.println(odd);
    }

    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static void display(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[50];
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        while (true) {
            int ch = sc.nextInt();

            if (ch == 1) {
                int pos = sc.nextInt();
                int val = sc.nextInt();
                insert(a, n, pos, val);
                n++;
                display(a, n);
            } 
            else if (ch == 2) {
                int pos = sc.nextInt();
                delete(a, n, pos);
                n--;
                display(a, n);
            } 
            else if (ch == 3) {
                int key = sc.nextInt();
                System.out.println(linearSearch(a, n, key));
            } 
            else if (ch == 4) {
                int key = sc.nextInt();
                System.out.println(binarySearch(a, n, key));
            } 
            else if (ch == 5) {
                System.out.println(maxValue(a, n));
            } 
            else if (ch == 6) {
                countEvenOdd(a, n);
            } 
            else if (ch == 7) {
                insertionSort(a, n);
                display(a, n);
            } 
            else if (ch == 8) {
                break;
            }
        }

        sc.close();
    }
}
