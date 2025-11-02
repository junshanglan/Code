package OD.T_2025.A.one.双指针;

import java.util.Scanner;

public class 最多购买宝石的数量 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= scanner.nextInt();
        }
        int money = scanner.nextInt();
        int left = 0,right = 0;
        int max = Integer.MIN_VALUE;
        while (right < n && left <= right) {
            int total = 0;
            for (int i = left; i <= right; i++) {
                total += arr[i];
            }
            if (total <= money) {
                max = Math.max(max,right - left + 1);
                right++;
            }else{
                left++;
            }
        }
        System.out.println(max);
    }
}
