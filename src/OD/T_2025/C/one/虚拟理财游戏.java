package OD.T_2025.C.one;

import java.util.Scanner;

/**
 * 最多投资两个产品
 */
public class 虚拟理财游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 产品数
        int n = scanner.nextInt();
        // 总投资额
        int investAmount = scanner.nextInt();
        // 可以接受的总风险
        int riskTotal = scanner.nextInt();
        // 产品投资的回报
        int[] huibao = new int[n];
        // 产品的风险
        int[] riskArr = new int[n];
        // 最大投资额序列
        int[] investArr = new int[n];
        for (int i = 0; i < n; i++) {
            huibao[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            riskArr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            investArr[i] = scanner.nextInt();
        }
        // 记录最优策略的分配数组
        int[] res = new int[n];
        int max = 0;
        // 投资单个产品,投资额度要够，且能够承受风险
        for (int i = 0; i < n; i++) {
            if (riskTotal >= riskArr[i] && investAmount >= investArr[i]){
                int[] tmp = new int[n];
                if (huibao[i] > max){
                    max = huibao[i];
                    tmp[i] = investArr[i];
                    res = tmp;
                }
            }
        }
        // 投资两个产品组合,投资额度要够，且能够承受风险
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            int riskRemain = riskTotal - riskArr[i];
            int investRemain = investAmount -  investArr[i];
            if (riskRemain > 0 && investRemain > 0){
                for (int j = i + 1; j < n; j++) {
                    if (riskRemain - riskArr[j] >= 0 && investRemain - investArr[j] >= 0) {
                        int sum = huibao[i] + huibao[j];
                        if (sum > max){
                            max = sum;
                            tmp[i] = investArr[i];
                            tmp[j] = investArr[j];
                            res = tmp;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
