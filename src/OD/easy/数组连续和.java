package OD.easy;

import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-10
 * @Author：landaguo
 */
public class 数组连续和 {

    /**
     * 3 7
     * 3 4 7
     * 4
     *
     * 10 10000
     * 1 2 3 4 5 6 7 8 9 10
     * 0
     * 动态规划
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }
        int l = 0;
        int r = 1;
        long ans = 0;
        while (r <= n) {
            if (preSum[r] - preSum[l] >= sum) {
                ans += n - r + 1;
                l++;
                r = l +1;
            }else{
                r++;
            }
        }
        System.out.println(ans);
    }
}
