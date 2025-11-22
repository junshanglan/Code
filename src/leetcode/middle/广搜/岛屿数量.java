package leetcode.middle.广搜;

import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {

    private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    static int rows,cols;
    public static int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    Queue<int[]> queue= new LinkedList<>();
                    queue.add(new int[]{i,j});
                    bfs(grid,queue,visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void bfs(char[][] grid, Queue<int[]> queue,boolean[][] visited){
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : directions) {
                int newX = pos[0] + dir[0] ;
                int newY = pos[1] + dir[1] ;
                if (newX < 0 || newX >=rows || newY < 0 || newY >= cols || visited[newX][newY] || grid[newX][newY] == '0') {
                    continue;
                }
                visited[newX][newY] = true;
                queue.add(new int[]{newX,newY});
            }
        }
    }
}
