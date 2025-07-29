package OD.T_2025.C.one;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2025-07-29
 * @Author：landaguo
 */
public class 围棋的气 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] blackArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] whiteArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] board = new int[19][19];
        // 填黑棋和白棋
        for (int i = 0; i < blackArr.length ; i+=2) {
            int x = blackArr[i];
            int y = blackArr[i+1];
            board[x][y] = 1;
        }
        for (int i = 0; i < whiteArr.length; i+=2) {
            int x = whiteArr[i];
            int y = whiteArr[i+1];
            board[x][y] = 2;
        }
        System.out.println(board);
        // 四个方向，左，右，下，上
        int[][] position = {{0,-1},{0,1},{1,0},{-1,0}};
        int blackCount = 0;
        int whiteCount = 0;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                boolean isBlack = false;
                boolean isWhite = false;
                // 说明当前位置是空的
                if (board[i][j] == 0) {
                    for (int[] pos : position) {
                        int newI = i + pos[0];
                        int newJ = j + pos[1];
                        // 说明越界了，继续
                        if (newI < 0 || newI > 18 || newJ < 0 || newJ > 18) continue;
                        isBlack = isBlack || board[newI][newJ] == 1;
                        isWhite = isWhite || board[newI][newJ] == 2;
                    }
                }
                if (isBlack) blackCount++;
                if (isWhite) whiteCount++;
            }
        }
        System.out.println(blackCount + " " + whiteCount);
    }
}
