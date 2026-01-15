import java.util.Scanner;

public class MatrixMenu {

    static void readMatrix(int[][] matrix, int rows, int columns, Scanner sc) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    static void displayMatrix(int[][] matrix, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void addMatrices(int[][] a, int[][] b, int rows, int columns) {
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        displayMatrix(result, rows, columns);
    }

    static void subtractMatrices(int[][] a, int[][] b, int rows, int columns) {
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        displayMatrix(result, rows, columns);
    }

    static void multiplyMatrices(int[][] a, int[][] b, int rows, int columns) {
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < columns; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        displayMatrix(result, rows, columns);
    }

    static void transposeMatrix(int[][] matrix, int rows, int columns) {
        int[][] transpose = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        displayMatrix(transpose, columns, rows);
    }

    static boolean isSquareMatrix(int rows, int columns) {
        return rows == columns;
    }

    static boolean isDiagonalMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j && matrix[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    static boolean isIdentityMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j && matrix[i][j] != 1)
                    return false;
                if (i != j && matrix[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int columns = sc.nextInt();

        int[][] matrixA = new int[rows][columns];
        int[][] matrixB = new int[rows][columns];

        readMatrix(matrixA, rows, columns, sc);
        readMatrix(matrixB, rows, columns, sc);

        while (true) {
            int choice = sc.nextInt();

            if (choice == 1) {
                addMatrices(matrixA, matrixB, rows, columns);
            } 
            else if (choice == 2) {
                subtractMatrices(matrixA, matrixB, rows, columns);
            } 
            else if (choice == 3) {
                multiplyMatrices(matrixA, matrixB, rows, columns);
            } 
            else if (choice == 4) {
                transposeMatrix(matrixA, rows, columns);
            } 
            else if (choice == 5) {
                System.out.println(isSquareMatrix(rows, columns));
            } 
            else if (choice == 6 && isSquareMatrix(rows, columns)) {
                System.out.println(isDiagonalMatrix(matrixA, rows));
            } 
            else if (choice == 7 && isSquareMatrix(rows, columns)) {
                System.out.println(isIdentityMatrix(matrixA, rows));
            } 
            else if (choice == 8) {
                break;
            }
        }

        sc.close();
    }
}
