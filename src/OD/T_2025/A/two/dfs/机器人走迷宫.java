package OD.T_2025.A.two.dfs;

import java.util.Scanner;

public class 机器人走迷宫 {
    static int x,y;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        x = scanner.nextInt();
        y = scanner.nextInt();
        int n = scanner.nextInt();
        grid = new int[x][y];
        for (int i = 0; i < n; i++) {
            int tmpX = scanner.nextInt();
            int tmpY = scanner.nextInt();
            grid[tmpX][tmpY] = -1;
        }
        // 终点
        grid[x -1][y - 1] = 2;
        dfs(0,0);
        int trap = 0;
        int notReach = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 1) {
                    trap ++;
                }
                if (grid[i][j] == 0) {
                    notReach++;
                }
            }
        }

        System.out.println(trap +" " + notReach);
    }
    private static boolean dfs(int currentX,int currentY){
        if (currentX < 0 || currentX > x - 1 || currentY < 0 || currentY > y - 1) {
            return false;
        }
        // 墙
        if (grid[currentX][currentY] == -1) {
            return false;
        }
        // 陷阱
        if (grid[currentX][currentY] == 1) {
            return false;
        }
        // 通的路
        if (grid[currentX][currentY] == 2) {
            return true;
        }
        // 向东
        boolean eastFlag = dfs(currentX + 1, currentY);
        // 向北
        boolean northFlag = dfs(currentX, currentY + 1);

        if (eastFlag || northFlag) {
            grid[currentX][currentY] = 2;
        }else{
            grid[currentX][currentY] = 1;
        }
        return eastFlag || northFlag;
    }
}
