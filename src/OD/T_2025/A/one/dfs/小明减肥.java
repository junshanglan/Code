package OD.T_2025.A.one.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 小明减肥 {

    static boolean[] visited;
    static int[] calories;
    static int n,t,k,count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        // 选择数，卡路里
        t = scanner.nextInt();
        k = scanner.nextInt();
        visited = new boolean[n];
        calories = new int[n];
        for (int i = 0; i < n; i++) {
            calories[i] = scanner.nextInt();
        }
        dfs(0,0,0);
        System.out.println(count);
    }

    private static void dfs(int idx,int selected,int sum) {
        if (selected == k) {
            if (sum == t) {
                count++;
            }
            return;
        }
        if (selected >= k || idx >= n) {
            return;
        }
        dfs(idx+1,selected + 1,sum + calories[idx]);
        dfs(idx+1,selected,sum);
    }
}
