package OD.T_2024.hard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-08-27
 * @Author：landaguo
 */
public class 游玩计划所需要的最低消费 {

    /**
     * 5 14 30 100
     * 1 3 5 20 21 200 202 230
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1日，3日，7日，30日
        int[] costs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 游玩日期
        int[] days = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 最大游玩日期
        int maxDay = days[days.length - 1];
        // 从1开始算
        int[] dp = new int[maxDay + 1];

        int index = 0;
        for (int i = 1; i <= maxDay; i++) {
            // 游玩的日期
            if (days[index] == i) {
                int buy1 = dp[i - 1] + costs[0];

                int buy2 = (i > 3 ? dp[i - 3] : 0) + costs[1];

                int buy3 = (i > 7 ? dp[i - 7] : 0) + costs[2];

                int buy4 = (i > 30 ? dp[i - 30] : 0) + costs[3];
                dp[i] += Math.min(Math.min(Math.min(buy1,buy2),buy3),buy4);
                index ++;
            }else{
                dp[i] = dp[i -1];
            }

        }
        System.out.println(dp[maxDay]);

    }
}
