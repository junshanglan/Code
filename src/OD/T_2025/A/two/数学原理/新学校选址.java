package OD.T_2025.A.two.数学原理;

import java.util.Arrays;
import java.util.Scanner;

public class 新学校选址 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        Arrays.sort(input);

        if (n % 2 == 1){
            System.out.println(input[n /2]);
        }else{
            System.out.println(input[n / 2 - 1]);
        }



    }
}
