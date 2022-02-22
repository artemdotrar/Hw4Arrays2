import java.util.Random;
import java.util.Scanner;

public class Hw4 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размерзность матрицы: ");
        int n = in.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = rand.nextInt(50);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        //1) Поcчитать сумму четных элементов стоящих на главной диагонали.
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            if (array[i][j] % 2 == 0) {
                sum1 += array[i][j];
            }
        }
        System.out.println("1)Сумма четных элементов на главной матрице: " + sum1 + "\n");

        //2)Вывести нечетные элементы находящиеся под главной диагональю(включительно).
        System.out.println("2)Нечетные элементы находящиеся под главной диагональю(включительно):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(array[i][j] % 2 != 0 ? array[i][j] + "\t" : "-\t");
            }
            System.out.println();
        }

        //3)Проверить произведение элементов какой диагонали больше.
        int mult1 = 1, mult2 = 1;
        for (int i = 0; i < n; i++) {
            int j = i;
            mult1 *= array[i][j];
        }
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            mult2 *= array[i][j];
        }
        System.out.println("\n3)Произведение элементов главной матрицы (" + mult1 + ") " + (mult1 > mult2 ? "больше" : "меньше") + " чем произведение на побочной (" + mult2 + ")");

        //4)Посчитать сумму четных элементов стоящих над побочной диагональю (не включительно)
        int sum4 = 0;
        System.out.println("\n4)Посчитать сумму четных элементов стоящих над побочной диагональю (не включительно): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[i][j] % 2 == 0) {
                    sum4 += array[i][j];
                    System.out.print(array[i][j] + "\t");
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println();
        }
        System.out.println("Сумма: " + sum4);

        //5)Транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д.)
        int[][] array2 = new int[n][n];
        System.out.println("\n5)Транспортировать матрицу: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array2[i][j] = array[j][i];
                System.out.print(array2[i][j] + "\t");
            }
            System.out.println();
        }
    }
}