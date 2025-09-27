package OD.T_2025.A.one.dfs;

import java.util.Scanner;

/**
 * 4 4
 * 1 1 0 0
 * 0 0 0 1
 * 0 0 1 1
 * 1 1 1 1
 * 输出：2
 *
 * 3 3
 * 1 0 1
 * 0 1 0
 * 1 0 1
 * 输出：1
 */
public class 开心消消乐 {
    private static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1,},{1,1}};

    private static int[][] grid ;
    // 行
    static int  N ;
    // 列
    static int M ;

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1){
                    dfs(i,j);
                    res ++;
                }
            }
        }

        System.out.println(res);

    }

    private static void dfs(int x,int y){
        // 当前元素反转为 0
        grid[x][y] = 0;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= M || newY < 0 || newY >= N || grid[newX][newY] == 0){
                continue;
            }
            dfs(newX,newY);
        }
    }
}
