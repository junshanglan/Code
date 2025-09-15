package OD.T_2025.C.two.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1 3
 * 1 =A1+C1 3
 * A1:C1
 * 输出：8
 * 5 3
 * 10 12 =C5
 * 15 5 6
 * 7 8 =3+C2
 * 6 =B2-A1 =C2
 * 7 5 3
 * B2:C4
 * 输出：29
 */
public class Excel单元格数值统计 {

    static char[] charArr = new char[]{'A','B','C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static Map<Character,Integer> letterMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(s[0]);
        int cols = Integer.parseInt(s[1]);
        String[][] input = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] tmp = scanner.nextLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                input[i][j] = tmp[j];
            }
        }

        for (int i = 0; i < charArr.length; i++) {
            letterMap.put(charArr[i],i);
        }
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String tmp = input[i][j];
                // 如果是数字，直接转就可以
                if (Character.isDigit(tmp.charAt(0))) {
                    grid[i][j] = Integer.parseInt(tmp);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String tmp = input[i][j];
                if(tmp.charAt(0) == '='){
                    tmp  = tmp.substring(1);
                    // 如果是表达式，分成三种情况
                    if (tmp.contains("-")) {
                        String[] split = tmp.split("-");
                        int res = expressionToInt(split[0], grid) - expressionToInt(split[1], grid);
                        grid[i][j] = res;
                    }else if (tmp.contains("+")) {
                        String[] split = tmp.split("\\+");
                        int res = expressionToInt(split[0], grid) + expressionToInt(split[1], grid);
                        grid[i][j] = res;
                    }else{
                        // B11
                        grid[i][j] = expressionToInt(tmp, grid);
                    }
                }
            }
        }
        String[] zone = scanner.nextLine().split(":");
        Integer colBegin = letterMap.get(zone[0].charAt(0));
        Integer colEnd = letterMap.get(zone[1].charAt(0));
        int rowBegin = Integer.parseInt(zone[0].substring(1)) - 1;
        int rowEnd = Integer.parseInt(zone[1].substring(1)) - 1;
        int res = 0;
        for (int i = rowBegin; i <= rowEnd; i++) {
            for (int j = colBegin; j <=colEnd; j++) {
                res += grid[i][j];
            }
        }
        System.out.println(res);
    }

    public static int expressionToInt(String tmp,int[][] grid){
        // 如果是数字，直接转就可以
        if (Character.isDigit(tmp.charAt(0))) {
            return Integer.parseInt(tmp);
        }else{
            // 是表达式，转化一下
            Integer col = letterMap.get(tmp.charAt(0));
            int row = Integer.parseInt(tmp.substring(1)) - 1;
            return grid[row][col];
        }
    }

}
