package OD;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-13
 * @Author：landaguo
 */
public class 围棋的气 {

    /**
     * 0 5 8 9 9 10
     * 5 0 9 9 9 8
     * 8 7
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] black = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] white = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] board = new int[19][19];
        for (int i = 0; i < black.length; i+=2) {
            int x = black[i];
            int y = black[i+1];
            board[x][y] = 1;
        }
        for (int i = 0; i < white.length; i+=2) {
            int x = white[i];
            int y = white[i+1];
            board[x][y] = 2;
        }
        int blackCount = 0;
        int whiteCount = 0;
        int [][] offsets = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                // 当前位置可能为气，上下左右要有棋子
                if (board[i][j] == 0) {
                    boolean is_black = false;
                    boolean is_white = false;

                    for (int[] offset : offsets) {
                        int newI = offset[0] + i;
                        int newJ = offset[1] + j;

                        if (newI < 0 || newI >=19 || newJ < 0 || newJ >=19) continue;

                        is_black = is_black || (board[newI][newJ] == 1);
                        is_white = is_white || (board[newI][newJ] == 2);
                    }
                    if (is_black) blackCount++;
                    if (is_white) whiteCount++;
                }
            }
        }
        System.out.println(blackCount + " " + whiteCount);

    }
}
