package OD.T_2025.A.one.贪心;

import java.util.Scanner;

/**
 * 注：每件商品可以反复的买入和卖出
 * 3
 * 3
 * 4 5 6
 * 1 2 3
 * 4 3 2
 * 1 5 2
 * 输出：
 *
 */
public class 贪心的商人 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 商品数
        int n = scanner.nextInt();
        // 天数
        int d = scanner.nextInt();
        int[] items = new int[n];
        int[][] dayPrice =new int[n][d];
        for (int i = 0; i < n; i++) {
            items[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                dayPrice[i][j] = scanner.nextInt();
            }
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < d; j++) {
                int res = Math.max(0, items[i] * dayPrice[i][j] - items[i] * dayPrice[i][j - 1]);
                maxProfit += res;
            }
        }

        System.out.println(maxProfit);
    }
}


