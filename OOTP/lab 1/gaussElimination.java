public class gaussElimination {

    public static void solve(double[][] matrix) {
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            int maxRow = i;
            for (int k = i + 1; k < size; k++) {
                if (Math.abs(matrix[k][i]) > Math.abs(matrix[maxRow][i])) {
                    maxRow = k;
                }
            }

            if (maxRow != i) {
                double[] temp = matrix[i];
                matrix[i] = matrix[maxRow];
                matrix[maxRow] = temp;
            }

            for (int k = i + 1; k < size; k++) {
                double factor = matrix[k][i] / matrix[i][i];
                for (int j = i; j <= size; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
            }
        }

        double[] solution = new double[size];
        for (int i = size - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < size; j++) {
                sum += matrix[i][j] * solution[j];
            }
            solution[i] = (matrix[i][size] - sum) / matrix[i][i];
        }

        System.out.println("Решение системы уравнений:");
        for (int i = 0; i < size; i++) {
            System.out.println("x" + (i + 1) + " = " + solution[i]);
        }
    }
}