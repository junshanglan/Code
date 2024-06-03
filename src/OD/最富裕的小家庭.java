package OD;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-06
 * @Author：landaguo
 */
public class 最富裕的小家庭 {

    /**
     * 4
     * 100 200 300 500
     * 1 2
     * 1 3
     * 2 4
     *
     * 700
     * 用例二：
     * 5
     * 100 200 300 400 500
     * 3 4
     * 3 5
     * 1 3
     * 1 2
     *
     * 1200
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] wealth = new int[n + 1];
        int[] family = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wealth[i] = scanner.nextInt();
            family[i] = wealth[i];
        }
        for (int i = 0; i < n - 1; i++) {
            int fa = scanner.nextInt();
            int ch = scanner.nextInt();
            family[fa] += wealth[ch];
        }
        System.out.println(Arrays.stream(family).max().orElse(0));
    }

}
