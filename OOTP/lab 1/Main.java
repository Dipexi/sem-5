import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность системы уравнений: ");
        int size = scanner.nextInt();

        double[][] matrix = new double[size][size + 1];

        System.out.println("Введите коэффициенты системы уравнений:");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size; j++) {
                System.out.print("Введите элемент матрицы [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Выберите метод решения (1 - Гаусс, 2 - Жордан-Гаусс): ");
        int method = scanner.nextInt();

        if (method == 1) {
            gaussElimination.solve(matrix);
        } else if (method == 2) {
            jordanGaussElimination.solve(matrix);
        } else {
            System.out.println("Некорректный метод решения.");
        }

        scanner.close();
    }
}

