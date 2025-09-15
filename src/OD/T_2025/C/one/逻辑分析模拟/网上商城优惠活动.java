package OD.T_2025.C.one.逻辑分析模拟;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 三种优惠活动，三选二
 */
public class 网上商城优惠活动 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int manCnt = scanner.nextInt();
        int daCnt = scanner.nextInt();
        int wuCnt = scanner.nextInt();
        int n = scanner.nextInt();
        int[] moneyArr = new int[n];
        for (int i = 0; i < n; i++) {
            moneyArr[i] = scanner.nextInt();
        }
        // 6种折扣方案
        String[][] zuhe = {{"man","da"},{"man","wu"},{"da","man"},{"da","wu"},{"wu","man"},{"wu","da"}};
        for (int money : moneyArr) {
            int tmp = money;
            int finalPrice = money;
            int minCount = 0;
            for (String[] fangan : zuhe) {
                int[] res1 = fangan[0].equals("man")?man(tmp,manCnt):fangan[0].equals("da")?da(tmp,daCnt):wu(tmp,wuCnt);
                int[] res2 = fangan[1].equals("man")?man(res1[0],manCnt):fangan[1].equals("da")?da(res1[0],daCnt):wu(res1[0],wuCnt);
                if (res2[0] < finalPrice) {
                    finalPrice = res2[0];
                    minCount = res2[1] + res1[1];
                }else if (res2[0] == finalPrice) {
                    minCount = Math.min(minCount,res2[1] + res1[1]);
                }
            }
            System.out.println(finalPrice + " " + minCount);
        }

    }

    public static int[] man(int sum,int manCnt){
        int used = Math.min(sum / 100,manCnt);
        return new int[]{sum - used * 10,used};
    }
    public static int[] da(int sum,int daCnt){
        int used = Math.min(1, daCnt);
        if (used > 0) {
            sum =  (int)Math.floor(sum * 0.92);
        }
        return new int[]{sum,used};
    }

    public static int[] wu(int sum,int wuCnt){
        int used = Math.min(sum / 5, wuCnt);
        return new int[]{sum - used *5,used};
    }
}
