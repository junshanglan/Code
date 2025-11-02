package OD.T_2024.easy;

import java.util.Arrays;
import java.util.Scanner;

public class 流浪地球 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 发动机总个数
        int n = scanner.nextInt();
        // 手动启动发动机个数
        int e = scanner.nextInt();

        int[] launches = new int[n];
        Arrays.fill(launches,1001);
        for (int i = 0; i < e; i++) {
            int t = scanner.nextInt();
            int p = scanner.nextInt();
            launches[p] = t;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int innerDis = Math.abs(i - j);
                int outerDis = n - innerDis;
                int dis = Math.min(innerDis, outerDis);

            }
        }




    }
}
