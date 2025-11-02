package OD.T_2024.hard;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Description：
 * @Date：2024-09-19
 * @Author：landaguo
 */
public class 找单词 {

    /**
     * 4
     * A,C,C,F
     * C,D,E,D
     * B,E,S,S
     * F,E,C,A
     * ACCESS
     * param args
     */
    static char[][] matrix;
    static String target;
    static boolean[][] used;
    static int n;
    static LinkedList<String> path = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("[,\n]");
        n = scanner.nextInt();
        matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }
        target = scanner.next();
        used = new boolean[n][n];
        String result = "N";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    StringJoiner sj = new StringJoiner(",");
                    for (String s : path) {
                        sj.add(s);
                    }
                    result =  sj.toString();
                }
            }
        }
        System.out.println(result);
    }
    public static boolean dfs(int i,int j,int k) {
        if (i < 0 || i >= n || j < 0 || j >= n || used[i][j] || target.charAt(k) != matrix[i][j]) {
            return false;
        }
        path.add(i + "," + j);
        // 递归结束，找到答案
        if (path.size() == target.length()) {
            return true;
        }
        used[i][j] = true;
        boolean res = dfs(i - 1, j, k + 1) ||
                dfs(i + 1, j, k + 1) ||
                dfs(i, j - 1, k + 1) ||
                dfs(i, j + 1, k + 1);
        if (!res) {
            used[i][j] = false;
            path.removeLast();
        }
        return res;
    }
}
