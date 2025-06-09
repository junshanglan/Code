import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("1234567890");
        sb.delete(2,5);
        System.out.println(sb);

    }

    public static int getResult(int[] arr) {
        int correct = 0;

        for (int i = 0; i < arr.length; i++) {
            int fault = arr[i];
            if (fault > 4) fault--;

            for (int j = arr.length - i - 1; j > 0; j--) {
                fault *= 9;
            }

            correct += fault;
        }

        return correct;
    }
}