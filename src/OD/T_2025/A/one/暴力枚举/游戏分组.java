package OD.T_2025.A.one.暴力枚举;

import sun.rmi.runtime.Log;

import java.util.Arrays;
import java.util.Scanner;

public class 游戏分组 {

    static int n;
    static long minDiff = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        n = input.length;
        long[] nums = new long[input.length];
        long total = 0l;
        for (int i = 0; i < input.length; i++) {
            long item = Long.parseLong(input[i]);
            nums[i] = item;
            total += item;
        }

    }

    private static void dfs(long[] nums,int idx,int count,long sum1 ,long totalSum){
        if (count == n/2) {
            long abs = Math.abs(totalSum - sum1);
            minDiff = Math.min(minDiff,abs);
        }

    }
}
