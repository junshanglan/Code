package OD.T_2025.B.动态规划;

import java.util.Scanner;

/**
 * @Description：动态规划01背包问题
 * @Date：2025-06-04
 * @Author：landaguo
 */
public class 最大报酬 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 需要工作的工时长
        int T = scanner.nextInt();
        // 有几个工作可以做
        int n = scanner.nextInt();
        int[] dp = new int[T+ 1];
        for (int i = 0; i < n; i++) {
            // 当前工作所消耗的时间
            int t = scanner.nextInt();
            // 当前工作所获取的酬劳
            int w = scanner.nextInt();
            for (int j = T; j  >= t; j--) {
                dp[j] = Math.max(dp[j],dp[j -t] + w);
            }
        }
        System.out.println(dp[T]);
    }

}
