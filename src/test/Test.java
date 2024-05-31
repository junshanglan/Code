package test;

import java.util.*;

/**
 * @Description：
 * @Date：2024-05-09
 * @Author：landaguo
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int sum = scanner.nextInt();

        int ans = 0;
        int l = 0;
        int r = 0;
        int window_sum = 0;

        while (r < n) {
            if (window_sum + arr[r] <= sum) {
                window_sum += arr[r++];
            }else {
                ans = Math.max(ans,r - l);
                window_sum -= arr[l++];
            }
        }
        if (window_sum <= sum){
            ans = Math.max(ans,r - l);
        }
        System.out.println(ans);
    }

}

