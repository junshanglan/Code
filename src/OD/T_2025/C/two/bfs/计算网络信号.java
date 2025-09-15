package OD.T_2025.C.two.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * 6 5
 * 0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
 * 1 4
 * 输出：2
 * 6 5
 * 0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 * 2 1
 * 输出：0
 *
 * BFS
 */
public class 计算网络信号 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];
        Queue<int[]> bfsQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
                if (grid[i][j] > 0) {
                    bfsQueue.offer(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!bfsQueue.isEmpty()) {
            // 出队列当前有值节点
            int[] pos = bfsQueue.poll();
            if (grid[pos[0]][pos[1]] == 1) continue;
            for (int[] dir : directions) {
                int newI = pos[0] + dir[0];
                int newJ = pos[1] + dir[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 0) {
                    grid[newI][newJ] = grid[pos[0]][pos[1]] - 1;
                    bfsQueue.offer(new int[]{newI,newJ});
                }
            }
        }
        int targetI = scanner.nextInt();
        int targetJ = scanner.nextInt();
        System.out.println(grid[targetI][targetJ]);
    }
}
