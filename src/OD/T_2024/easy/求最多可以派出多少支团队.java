package OD.T_2024.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-20
 * @Author：landaguo
 */
public class 求最多可以派出多少支团队 {

    /**
     * 5
     * 3 1 5 7 9
     * 8
     * 答案：3
     *
     * 7
     * 3 1 5 7 9 2 6
     * 8
     * 4
     *
     * 3
     * 1 1 9
     * 8
     * 1
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ability  = new int[n];
        for (int i = 0; i < n; i++) {
            ability[i] = scanner.nextInt();
        }
        int low = scanner.nextInt();
        int l = 0;
        int r = ability.length - 1;
        int ans = 0;
        Arrays.sort(ability);
        while (l < r) {
            if (ability[r] >= low) {
                ans++;
                r--;
            }else{
                if (ability[r] + ability[l] >= low) {
                    ans++;
                    r--;
                }
                l++;
            }
        }
        System.out.println(ans);
    }
}
