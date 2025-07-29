package OD.T_2025.C.one;

import java.util.Scanner;

/**
 * 两种解法，图的遍历
 */
public class 小明地图寻宝 {

    static int n;
    static int m;
    static int k;

    static int[][] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        k = scanner.nextInt();
        visited = new int[m][n];
        scanner.close();
        System.out.println(dfs(0,0));
    }

    /**
     * 往四个方向走
     */
    public static int dfs(int x,int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] == 1) {
            return 0;
        }
        int sumTotal = 0;
        int xx = x;
        while (xx > 0) {
            sumTotal += xx % 10;
            xx = xx / 10;
        }

        int yy = y;
        while (yy > 0) {
            sumTotal += yy % 10;
            yy = yy / 10;
        }
        if (sumTotal > k){
            return 0;
        }
        visited[x][y] = 1;
        int res = 1;
        if (x+1 < m) {
            res += dfs(x+1,y);
        }
        if (x - 1 >= 0) {
            res += dfs(x-1,y);
        }
        if (y+1 < n) {
            res += dfs(x,y + 1);
        }
        if (y - 1 >= 0) {
            res += dfs(x,y - 1);
        }
        return res;
    }
}
