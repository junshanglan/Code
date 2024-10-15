package OD.hard;

import java.util.Scanner;

/**
 * 动态规划
 */
public class 园区参观路径 {

    /**
     *  3 3
     *  0 0 0
     *  0 1 0
     *  0 0 0
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 长，行数
        int n = scanner.nextInt();
        // 宽，列数
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        if (matrix[0][0] == 1 || matrix[n-1][m-1] == 1) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) continue;

                if (i > 0 ) {
                    dp[i][j] += dp[i-1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        System.out.println(dp[n- 1][m-1]);


    }
}
