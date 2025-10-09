package OD.T_2025.A.one.递归回溯;

import java.util.Scanner;

/**
 * 没做完
 * 递归回溯
 */
public class MPV争夺战 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] scoreArr = new int[t];
        int sum = 0;

        for (int i = 0; i < t; i++) {
            int tmp = scanner.nextInt();
            scoreArr[i] = tmp;
            sum += tmp;
        }
        // 有多少人得分
        int count = t;
        // 每个人的平均分
        while (count > 0) {
            // 还要能整出，如不能，则继续执行
            if (sum % count != 0) {
                count--;
                continue;
            }

            sum / count
        }

        //

    }
}
