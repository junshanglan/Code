package OD.T_2025.C.one;

import java.util.Scanner;

/**
 * 题目意思看半天没看懂，后面要在回顾一下
 */
public class 分苹果 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int yihuo = 0;
        int total = 0;
        int min = 20000;
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            yihuo ^= tmp;
            total += tmp;
            min = Math.min(min, tmp);
        }
        if (yihuo != 0) {
            System.out.println(-1);
        }else{
            System.out.println(total - min);
        }
    }
}
