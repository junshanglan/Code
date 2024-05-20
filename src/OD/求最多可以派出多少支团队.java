package OD;

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
     * 3
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
        int n = Integer.parseInt(scanner.nextLine());
        int[] data = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int minCap = Integer.parseInt(scanner.nextLine());

        int l = 0;
        int r = n - 1;
        int ans = 0;
        Arrays.sort(data);

        while (r >= 0 && data[r] >= minCap) {
            r--;
            ans++;
        }
        while (r > l ) {
            if ((data[l] + data[r]) >= minCap) {
                l++;
                r--;
                ans++;
            }else{
                l++;
            }
        }
        System.out.println(ans);
    }
}
