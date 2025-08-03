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
        int total = scanner.nextInt();
        // 可以接受的总风险
        int riskTotal = scanner.nextInt();
        // 产品投资的回报
        int[] huibao = new int[n];
        // 产品的风险
        int[] riskArr = new int[n];
        // 最大投资额序列
        int[] edu = new int[n];
        for (int i = 0; i < n; i++) {
            huibao[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            riskArr[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            edu[i] = scanner.nextInt();
        }
    }
}
