package OD.T_2025.A.one.并查集;

import java.util.*;

public class 精准核酸检测 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(",");
         List<Integer> confirmList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            confirmList.add(Integer.parseInt(input[i]));
        }
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(",");
            for (int j = 0; j < split.length; j++) {
                grid[i][j] = Integer.parseInt(split[j]);
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 有交集
                    merge(i,j,ans);
                }
            }
        }

        Set<Integer> infectList = new HashSet<>();
        for (Integer i : confirmList) {
            infectList.add(find(i,ans));
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (infectList.contains(find(i,ans))) {
                res++;
            }
        }

        System.out.println(res - infectList.size());

    }

    private static int find(int i,int[] ans){
        if (ans[i] == i) return i;
        return find(ans[i],ans);
    }

    private static void merge(int i,int j,int[] ans){
        int rootI = find(i, ans);
        int rootJ = find(j, ans);
        int newRoot = Math.min(rootI, rootJ);
        ans[i] = newRoot;
        ans[j] = newRoot;
    }
}
