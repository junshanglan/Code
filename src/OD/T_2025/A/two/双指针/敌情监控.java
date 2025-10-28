package OD.T_2025.A.two.双指针;

import java.util.Scanner;

public class 敌情监控 {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        // 兵营总数
        int n = scanner.nextInt();
        // 连续兵营数
        int k = scanner.nextInt();
        // l条命令
        int l = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < l; i++) {
            String command = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if ("Query".equals(command)){
                int minValue = Integer.MAX_VALUE;
                for (int j = a-1; j < b - k + 1; j++) {
                    // 连续的兵营数
                    int tmp = 0;
                    for (int m = j; m < k + j; m++) {
                        tmp += nums[m];
                    }
                    minValue = Math.min(tmp,minValue);
                }
                System.out.println(minValue);
            }else if ("Add".equals(command)){
                nums[a - 1] += b;
            }else if ("Sub".equals(command)){
                nums[a - 1] -= b;
            }
        }

    }
}
