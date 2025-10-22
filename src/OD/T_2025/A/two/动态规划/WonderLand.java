package OD.T_2025.A.two.动态规划;

import java.util.Scanner;

public class WonderLand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] costInput = scanner.nextLine().split(" ");
        String[] dayInput = scanner.nextLine().split(" ");
        int[] cost = new int[costInput.length];
        for (int i = 0; i < costInput.length; i++) {
            cost[i] = Integer.parseInt(costInput[i]);
        }
        int[] day = new int[dayInput.length];
        for (int i = 0; i < dayInput.length; i++) {
            day[i] = Integer.parseInt(dayInput[i]);
        }
        int maxDay = day[day.length -1];
        int index = 0;
        int[] dp = new int[maxDay + 1];
        for (int i = 1; i <= maxDay; i++) {
            if (i != day[index]) {
                dp[i] = dp[i - 1];
                continue;
            }
            int buyOne = dp[i-1] + cost[0];
            int buyThree = (i > 3 ? dp[i - 3] : 0) + cost[1];
            int buySeven = (i > 7 ? dp[i - 7] : 0) + cost[2];
            int bueMonth = (i > 30 ? dp[i - 30] : 0) + cost[3];
            dp[i] = Math.min(Math.min(Math.min(buyOne, buyThree), buySeven), bueMonth);
            index++;
        }
        System.out.println(dp[maxDay]);

    }
}
