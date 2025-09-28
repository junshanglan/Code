package OD.T_2025.B.模拟;

import java.util.*;

/**
 * @Description：
 * @Date：2025-05-27
 * @Author：landaguo
 */
public class 流水线 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 流水线数
        int m = scanner.nextInt();
        // 任务数
        int n = scanner.nextInt();
        int[] task= new int[n];
        for (int i = 0; i < n; i++) {
            task[i ] = scanner.nextInt();
        }
        Arrays.sort(task);
        // 流水线数与作业数
        if (n <= m) {
            System.out.println(task[n-1]);
            return;
        }
        int[] resArr = new int[m];
        for (int i = 0; i < n; i++) {
            int index = i % m;
            resArr[index] += task[i];
        }
        Arrays.sort(resArr);
        System.out.println(resArr[m - 1]);

    }

}
