package OD.T_2025.A.one.动态规划;

import java.util.Scanner;

public class 猴子爬山 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            if (i < 3) {
                dp[i] += dp[i -1];
            }else {
                dp[i] = dp[i - 1] + dp[i - 3];
            }
        }
        System.out.println(dp[n]);
    }
}
