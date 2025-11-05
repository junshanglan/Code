package OD.T_2025.A.one.单调栈;

import java.util.Arrays;
import java.util.Scanner;

public class 流量波峰1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (arr.length < 3){
            System.out.println(-1);
            return;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            int cur = arr[i];
            int left = -1,right = -1;
            // 向左找
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < cur) {
                    left = j;
                    break;
                }
            }
            // 向右找
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < cur) {
                    right = j;
                    break;
                }
            }
            if (left != -1 && right != -1) {
                res = Math.min(res,right - left);
            }
        }
        System.out.println(res == Integer.MAX_VALUE? -1:res);
    }
}
