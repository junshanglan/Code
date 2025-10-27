package OD.T_2025.A.one.递归回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 没做完
 * 递归回溯
 */
public class MPV争夺战 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        // 有得分的分钟数
        int t = scanner.nextInt();
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < t; i++) {
            int tmp = scanner.nextInt();
            ans.add(tmp);
            sum += tmp;
        }
        // 降序排
        ans.sort((a,b) -> {
            return b -a;
        });
        // 有多少人得分
        int n = t;
        // 每个人的平均分
        while (n != 1) {
            if (canSeg(n,sum,ans)) {
                break;
            }
            n--;
        }
        System.out.println(sum / n);
    }
    private static boolean canSeg(int n,int sum,List<Integer> ans){
        // 还要能整除，如不能，则继续执行
        if (sum % n != 0) {
            return false;
        }
        // 目标得分
        int subSum = sum / n;
        if (ans.get(0) > subSum){
            return false;
        }
        int begin = 0;
        while (begin < n && ans.get(begin) == subSum) {
            n--;
            begin++;
        }
        if (n == 0) {
            return true;
        }
        // 目标有n个人得分，且每个人得分是subSum
        int[] buckets = new int[n];
        return backtrack(begin,ans.size(),buckets,subSum,ans);
    }

    private static boolean backtrack(int index,int right,int[] buckets,int subSum,List<Integer> ans){
        if (index == right) {
            for (int bucket : buckets) {
                if (bucket != subSum) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < buckets.length; i++) {
            // 对称性剪枝
            if (i > 0 && buckets[i] == buckets[i - 1]) {
                continue;
            }
            if (buckets[i] + ans.get(index) > subSum) {
                continue;
            }
            buckets[i] += ans.get(index);
            if (backtrack(index + 1,right,buckets,subSum,ans)) {
                return true;
            }
            buckets[i] -= ans.get(index);
        }
        return false;
    }
}

