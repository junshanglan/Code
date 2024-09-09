package OD.easy;

import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-09-05
 * @Author：landaguo
 */
public class 计算面积绘图机器 {

    /**
     * 4 10
     * 1 1
     * 2 1
     * 3 1
     * 4 -2
     * -------------
     * 2 4
     * 0 1
     * 2 -2
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // N条指令
        int n = scanner.nextInt();
        // 终点
        int end_x = scanner.nextInt();

        int last_x = 0;
        int last_y = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur_x = scanner.nextInt();
            int offset_y = scanner.nextInt();
            // 计算每一次位移单元的面积
            ans += (cur_x - last_x ) * Math.abs(last_y);

            last_x = cur_x;
            last_y += offset_y;
        }

        if (end_x > last_x) {
            ans += (end_x - last_x) * Math.abs(last_y);
        }
        System.out.println(ans);
    }
}
