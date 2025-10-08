package OD.T_2025.A.two.贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 10 2
 * 1 1 2
 * 120 20
 * 90 10
 */
public class 贪心歌手 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        // 总天数
        int t = scanner.nextInt();
        // 经过 n个城市
        int n = scanner.nextInt();
        int costDay  = 0;
        for (int i = 0; i <= n; i++) {
            int dis = scanner.nextInt();
            costDay += dis;
        }
        if (t < costDay) {
            System.out.println(0);
            return;
        }
        // 剩余的可以用来赚钱的天数
        int remainDay = t - costDay;
        int[][] cityIncome = new int[n][2];
        for (int i = 0; i < n; i++) {
            cityIncome[i][0] = scanner.nextInt();
            cityIncome[i][1] = scanner.nextInt();
        }
        // 定义赚钱的数组，最后按照倒序排序
        List<Integer> incomelist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int income = cityIncome[i][0];
            int decay = cityIncome[i][1];
            while (income > 0){
                incomelist.add(income);
                income -= decay;
            }
        }
        incomelist.sort(Collections.reverseOrder());
        int totalIncome = 0;
        for (int i = 0; i < remainDay && i < incomelist.size(); i++) {
            totalIncome += incomelist.get(i);
        }
        System.out.println(totalIncome);
    }
}
