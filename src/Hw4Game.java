import java.util.Scanner;

public class Hw4Game {
    public static void main(String[] args) {
        int n = 3;
        int[][] array = new int[n][n];
        Scanner in = new Scanner(System.in);
        int winner = 0;
        int currGamer = 1; //номер игрока и его метка
        boolean standOff = false;


        while (winner == 0) { //игровой процесс
            //ходы игроков
            while (true) {
                System.out.print("Ход игрока " + currGamer + ", x: ");
                int x = in.nextInt();
                System.out.print("y: ");
                int y = in.nextInt();
                if (array[x][y] == 0) {
                    array[x][y] = currGamer;
                    break;
                } else {
                    System.out.println("Клетка уже занята!");
                }
            }
            //вывод игрового поля
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (array[i][j] == 0) {
                        System.out.print("-\t");
                    } else if (array[i][j] == 1) {
                        System.out.print("x\t");
                    } else {
                        System.out.print("o\t");
                    }
                }
                System.out.println();
            }
            //проверка на конец игры
            boolean win = true;//главная диагональ
            for (int i = 0; i < n - 1; i++) {
                if (array[i][i] != array[i + 1][i + 1] || array[i + 1][i + 1] == 0) {
                    win = false;
                    break;
                }
            }
            if (win) {
                break;
            }
            win = true;//побочная диагональ
            for (int i = 0; i < n - 1; i++) {
                int j = n - 1 - i;
                if (array[i][j] != array[i + 1][j - 1] || array[i + 1][j - 1] == 0) {
                    win = false;
                    break;
                }
            }
            if (win) {
                break;
            }
            for (int i = 0; i < n; i++) {//проверка по строкам
                win = true;
                for (int j = 0; j < n - 1; j++) {
                    if (array[i][j] != array[i][j + 1] || array[i][j + 1] == 0) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    break;
                }
            }
            if (win) {
                break;
            }
            for (int j = 0; j < n; j++) {//проверка по столбцам
                win = true;
                for (int i = 0; i < n - 1; i++) {
                    if (array[i][j] != array[i + 1][j] || array[i + 1][j] == 0) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    break;
                }
            }
            if (win) {
                break;
            }
            standOff = true; //проверка на ничью
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (array[i][j] == 0) {
                        standOff = false;
                    }
                }
            }
            if (standOff) {
                break;
            }
            currGamer = currGamer == 1 ? 2 : 1;
        }
        if (standOff) {
            System.out.println("Конец! Ничья");
        } else {
            System.out.println("Конец! Победил игрок " + currGamer);
        }
    }
}
