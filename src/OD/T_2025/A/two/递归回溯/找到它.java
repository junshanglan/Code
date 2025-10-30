package OD.T_2025.A.two.递归回溯;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 找到它 {

    static Character[][] matrix;
    // 上下左右
    static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    static int n,m;
    static String target;

    static boolean isFind = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] one = scanner.nextLine().split(" ");
        n = Integer.parseInt(one[0]);
        m = Integer.parseInt(one[1]);
        target = scanner.nextLine();
        matrix = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = tmp.charAt(j);
            }
        }
        String res = "NO";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target.charAt(0)) {
                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;
                    dfs(i,j,1,visited);
                    visited[i][j] = true;
                    if (isFind) {
                        res = (i + 1) + " " + (j + 1);
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }

    private static boolean dfs(int x,int y,int index,boolean[][] visited){
        if (index == target.length()) {
            isFind = true;
            return true;
        }
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newX][newY]) {
                continue;
            }
            if (matrix[newX][newY] == target.charAt(index)) {
                visited[newX][newY] = true;
                dfs(newX,newY,index+ 1,visited);
                visited[newX][newY] = false;
            }
        }
        return false;
    }
}
