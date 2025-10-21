package OD.T_2025.A.two.递归回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 基站维修工程师 {
    static int[][] matrix ;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int res = Integer.MAX_VALUE;
        res = findMinPath(res);
        System.out.println(res);
    }

    private static int findMinPath(int res){
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> path = new ArrayList<>();
        boolean[] visited = new boolean[n];
        dfs(currentPath,path,visited);
        for (List<Integer> list : path) {
            int tmp = matrix[0][list.get(0)];
            for (int i = 0; i < list.size() - 1; i++) {
                tmp += matrix[list.get(i)][list.get(i+1)];
            }
            tmp += matrix[list.get(list.size()-1)][0];
            res = Math.min(res,tmp);
        }
        return res;
    }

    private static void dfs(List<Integer> currentPath,  List<List<Integer>> path,boolean[] visited){
        if (currentPath.size() == n -1){
            path.add(new ArrayList<>(currentPath));
            return;
        }
        for (int i = 1; i < n; i++) {
            if (!visited[i]) {
                currentPath.add(i);
                visited[i] = true;
                dfs(currentPath, path, visited);
                visited[i] = false;
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }
}
