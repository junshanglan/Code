package OD.T_2025.C.one;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  BFS
 */
public class 数值同化 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        grid[0][0] = 1;
        scanner.close();
        bfs(grid,m,n);
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public static void bfs(int[][] grid,int m,int n){
        // 上下左右
        int[][] position = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : position) {
                int newI = pos[0] + dir[0];
                int newJ = pos[1] + dir[1];
                if (newI >= 0 && newI < m && newJ >= 0  && newJ < n && grid[newI][newJ] == 0) {
                    grid[newI][newJ] = 1;
                    queue.offer(new int[]{newI,newJ});
                }
            }
        }

    }
}
