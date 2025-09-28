package OD.T_2025.B.字符串;

import java.util.Scanner;

/**
 * @Description：取余的方式取到数组开始的几位
 * @Date：2025-07-09
 * @Author：landaguo
 */
public class 最小循环子数组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int count = 1; count < n; count++) {
            if (n % count != 0) continue;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (arr[i] != arr[i % count]){
                     flag = false;
                     break;
                }
            }
            if(flag) {
                for (int i = 0; i < count; i++) {
                    System.out.print(arr[i]);
                    System.out.print(" ");
                    return;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
