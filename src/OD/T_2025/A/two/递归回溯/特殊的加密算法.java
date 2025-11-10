package OD.T_2025.A.two.递归回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 特殊的加密算法 {
    static int m ;
    static String minStr = "";
    static boolean[][] visited ;
    static int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] books ;
    // 标记变量，第一次minStr比较
    static boolean found;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] plainText = new int[n];
        for (int i = 0; i < n; i++) {
            plainText[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        books = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                books[i][j] = scanner.nextInt();
            }
        }
        visited = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (books[i][j] == plainText[0]) {
                    List<String> path = new ArrayList<>();
                    dfs(plainText,0,i,j,path);
                }
            }
        }
        System.out.println(minStr.equals("") ? "error":minStr);
    }

    private static void dfs(int[] plainText, int index,int x,int y, List<String> path ){
        if (index == plainText.length) {
            String currentStr = String.join(" ", path);
            // 第一次比较会进来
            if (!found || minStr.compareTo(currentStr) > 0) {
                minStr = currentStr;
            }
            found = true;
            return;
        }
        if (x < 0 || x >= m || y < 0 || y >= m ||visited[x][y] || books[x][y] != plainText[index]){
            return;
        }
        path.add(x + " " + y);
        visited[x][y] = true;
        for (int[] dir : directions) {
            dfs(plainText,index +1,x + dir[0],y + dir[1],path);
        }
        visited[x][y] = false;
        path.remove(path.size() - 1);

    }
}
