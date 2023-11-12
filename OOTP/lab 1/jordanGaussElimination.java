public class jordanGaussElimination {

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

            for (int k = 0; k < size; k++) {
                if (k != i) {
                    double factor = matrix[k][i] / matrix[i][i];
                    for (int j = i; j <= size; j++) {
                        matrix[k][j] -= factor * matrix[i][j];
                    }
                }
            }
        }

        double[] solution = new double[size];
        for (int i = 0; i < size; i++) {
            solution[i] = matrix[i][size] / matrix[i][i];
        }

        System.out.println("Решение системы уравнений:");
        for (int i = 0; i < size; i++) {
            System.out.println("x" + (i + 1) + " = " + solution[i]);
        }
    }
}
