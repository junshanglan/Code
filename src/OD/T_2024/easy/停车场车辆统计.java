package OD.T_2024.easy;

import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-09-07
 * @Author：landaguo
 */
public class 停车场车辆统计 {

    /**
     * 1,0,1
     * 1,1,0,0,1,1,1,0,1
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll(",", "")
                .replaceAll("111", "x")
                .replaceAll("11", "x")
                .replaceAll("1", "x");
        int ans = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'x'){
                ans++;
            }
        }

        System.out.println(ans);
    }
}
