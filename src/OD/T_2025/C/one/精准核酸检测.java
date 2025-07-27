package OD.T_2025.C.one;

import java.util.*;

/**
 * 图的遍历
 * 使用并查集
 */
public class 精准核酸检测 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 总人数
        int n = Integer.parseInt(scanner.nextLine());
        String[] confirmStr = scanner.nextLine().split(",");
        // 确诊编号
        List<Integer> confirmList = new ArrayList<>();
        for (String s : confirmStr) {
            confirmList.add(Integer.parseInt(s));
        }
        // 初始化接触矩阵
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(",");
            for (int j = 0; j < line.length; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }
        // 初始化接触数据
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }

        // 迭代矩阵数组，合并接触人群
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < i; j++) {
                if (grid[i][j] == 1){
                     merge(i,j,ans);
                }
            }
        }
        // 感染组
        Set<Integer> infectList = new HashSet<>();
        for (Integer i : confirmList) {
            infectList.add(find(i,ans));
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (infectList.contains(find(i,ans)))
                res++;
        }
        System.out.println(res - confirmList.size());
        
    }

    // 寻找当前数的根节点
    public static int find(int i,int[] ans){
        if (i == ans[i]) return i ;
        return find(ans[i],ans);
    }

    // 将有接触的人群合并成一个组
    public static void merge(int a,int b,int[] ans) {
        Integer rootA = find(a, ans);
        Integer rootB = find(b, ans);
        int newRoot = Math.min(rootA, rootB);
        ans[a] = newRoot;
        ans[b] = newRoot;
    }

}
