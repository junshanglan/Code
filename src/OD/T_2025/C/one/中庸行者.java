package OD.T_2025.C.one;

import java.util.Scanner;

/**
 */
public class 中庸行者 {

    static int res = 0;
    static int rows;
    static int cols;
    // 右、左、下、上
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] grid;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                visited[i][j] = true;
                dfs(visited,i,j,0,0);
            }
        }
        System.out.println(res);
    }

    public static void dfs(boolean[][] visited, int x, int y, int lastType,int n){
        res = Math.max(res,n);
        for (int[] dir : dirs) {
            int newI = dir[0] + x;
            int newJ = dir[1] + y;
            // 判断是否越界
            if (newI < 0 || newI >= rows || newJ < 0 || newJ >= cols || visited[newI][newJ]) {
                continue;
            }
            // 相等高度的位置也不能走
            if (grid[newI][newJ] == grid[x][y]) {
                continue;
            }
            // 大于未1，小于未 -1
            int compare = grid[newI][newJ] > grid[x][y] ? 1 :  -1;
            // 和上一次的结果对比，不能连续走上坡或者连续下坡
            if (lastType !=0 && lastType == compare) {
                continue;
            }
            visited[newI][newJ] = true;
            dfs(visited, newI, newJ, compare,n+1);
            visited[newI][newJ] = false;
        }
    }
}
