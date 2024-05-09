package OD;

import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-08
 * @Author：landaguo
 */
public class 最多购买宝石数目 {

    /**
     * 7
     * 8
     * 4
     * 6
     * 3
     * 1
     * 6
     * 7
     * 10
     * ==============
     * 9
     * 6
     * 1
     * 3
     * 1
     * 8
     * 9
     * 3
     * 2
     * 4
     * 15
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] data = new int[num];
        for (int i = 0; i < num; i++) {
            data[i] = scanner.nextInt();
        }
        int value = scanner.nextInt();
        int window_sum = 0;
        int l = 0;
        int r = 0;
        int ans = 0 ;

        while (r < num) {
            if (window_sum + data[r]  <= value) {
                window_sum += data[r++];
            }else{
                ans = Math.max(ans,r - l );
                window_sum -= data[l++];
            }
        }

        if (window_sum <= value) {
            ans = Math.max(ans,r - l );
        }

        System.out.println(ans);
    }
}






















