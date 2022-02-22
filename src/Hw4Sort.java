import java.util.Random;

public class Hw4Sort {
    public static void main(String[] args) {
        int n = 10;
        int array[] = new int[n];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
            System.out.print(array[i] + "\t");
        }

        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i + 1]){
                    int min = array[i +1];
                    array[i + 1] = array[i];
                    array[i] = min;
                }
            }
        }

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
