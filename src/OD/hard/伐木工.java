package OD.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class 伐木工 {


    static class Wood{
        // 收益
        int profit;
        List<Integer> slices = new ArrayList<>();
    }

    /**
     * 10
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 木材长度
        int x = scanner.nextInt();
        // 木材dp数组，记录每个长度的状态
        Wood[] dp = new Wood[x +1];
        for (int i = 1; i <= x; i++) {
            dp[i] = new Wood();
            dp[i].profit = i;
            dp[i].slices.add(i);
        }

        for (int i = 2; i <=x ; i++) {
            for (int j = 1; j < i; j++) {
                int profit = dp[j].profit * dp[i - j].profit;

                // 如果收益大，或者收益相等，但切割数更少
                if (profit > dp[i].profit ||
                        (dp[i].profit == profit && dp[i].slices.size() >  (dp[j].slices.size() + dp[i - j].slices.size())  )) {
                    dp[i].profit = profit;
                    dp[i].slices.clear();
                    dp[i].slices.addAll(dp[j].slices);
                    dp[i].slices.addAll(dp[i - j].slices);
                }
            }
        }

        dp[x].slices.stream().sorted();

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < dp[x].slices.size(); i++) {
            sj.add(dp[x].slices.get(i) + "");
        }

        System.out.println(sj);
    }
}
