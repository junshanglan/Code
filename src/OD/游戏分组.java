package OD;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-06
 * @Author：landaguo
 */
public class 游戏分组 {

    /**
     * 5 1 8 3 4 6 7 10 9 2
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(data).sum();
        int min_abs = Integer.MAX_VALUE;
        for (int i = 0; i <= 5; i++) {
            for (int j = i+1; j < 10; j++) {
                for (int k = j + 1; k < 10; k++) {
                    for (int l = k+1; l < 10; l++) {
                        for (int m = l+1; m < 10; m++) {
                            int temp = data[i] + data[j] + data[k] + data[l] + data[m];
                            int abs = Math.abs(sum - temp - temp);
                            if (abs < min_abs) {
                                min_abs  = abs;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min_abs);
    }
}
