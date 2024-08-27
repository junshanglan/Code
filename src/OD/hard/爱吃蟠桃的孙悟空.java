package OD.hard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-14
 * @Author：landaguo
 */
public class 爱吃蟠桃的孙悟空 {
    /**
     * 2 3 4 5
     * 4
     * -- 5
     *
     * 2 3 4 5
     * 3
     *-- 0
     * 30 11 23 4 20
     * 6
     * -- 23
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cnts = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int limit = scanner.nextInt();

        int min = 1;
        int max = Arrays.stream(cnts).max().orElse(0);

        int ans = max;
        // 树大于小时数，肯定吃不完
        if (cnts.length > limit) {
            System.out.println(0);
            return;
        }
        // 树等于小时数，取最大
        if (cnts.length == limit) {
            System.out.println(max);
            return;
        }
        while (min <= max) {
            int mid = (min + max) >> 1;
            if (check(mid,limit,cnts)) {
                ans = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean check(int speed,int limit,int[] cnts){
        int cost = 0;
        for (int cnt : cnts) {
            // 累加消耗每棵树需要多长时间
            cost += cnt / speed + (cnt % speed == 0 ? 0 : 1);
        }
        if (cost > limit) return false;
        return true;
    }
}
