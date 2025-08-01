package OD.T_2025.C.two;

import java.util.Scanner;

/**
 *
 */
public class 连续出牌数量 {

    static int count = 1;
    static int n ;

    static int[] visited ;
    static String[] numArr;
    static String[] colorArr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numArr = scanner.nextLine().split(" ");
        colorArr = scanner.nextLine().split(" ");
        n = numArr.length;
        visited = new int[n];
        int res = 0;
        dfs("","",res);
        System.out.println(count);
    }

    public static void dfs(String lastValue,String lastColor,int res){
        count = Math.max(count,res);
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) continue;
            if (visited[i] == 0 && (numArr[i].equals(lastValue) || colorArr[i].equals(lastColor)
                || "".equals(lastValue) || "".equals(lastColor)) ){
                visited[i] = 1;
                dfs(numArr[i],colorArr[i],res + 1);
                visited[i] = 0;
            }
        }
    }
}
