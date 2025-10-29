package OD.T_2025.A.two.二分;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 二分法，middle值的计算注意
 */
public class 取出尽可能少的球 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum = scanner.nextInt();
        int n = scanner.nextInt();
        long[] bucketBall = new long[n];
        long total = 0;
        int maxCapacity = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            maxCapacity = Math.max(maxCapacity,tmp);
            bucketBall[i] = tmp;
            total += tmp;
        }
        if (total <= sum ) {
            System.out.println("[]");
            return;
        }
        long left = 0,right = maxCapacity;

        while (left < right) {
            long middle = left +  (right - left + 1) / 2;
            long tmpSum = 0;
            for (int i = 0; i < bucketBall.length; i++) {
                if (bucketBall[i] > middle){
                    tmpSum += middle;
                }else{
                    tmpSum += bucketBall[i];
                }
            }
            if (tmpSum <= sum) {
                left = middle;
            }else{
                right = middle - 1;
            }
        }
        long[] takeOut = new long[n];
        for (int i = 0; i < bucketBall.length; i++) {
            takeOut[i] = Math.max(0,bucketBall[i] - left);
        }
        System.out.println(Arrays.toString(takeOut));
    }
}
