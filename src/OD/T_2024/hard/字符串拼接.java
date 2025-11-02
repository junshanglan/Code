package OD.T_2024.hard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：  回溯算法、排列问题
 * @Date：2024-09-14
 * @Author：landaguo
 */
public class 字符串拼接 {

    /**
     * abc 1
     * -- 3
     * dde 2
     * 2
     * @param args
     */

    static int n = 0 ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        String M = split[0];
        char[] input = M.toCharArray();
        n = Integer.parseInt(split[1]);
        int result = getResult(input);
        System.out.println(result);
    }

    public static int getResult(char[] input){
        if (input.length < n) return 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > 'z' && input[i] < 'a') {
                return 0;
            }
        }
        Arrays.sort(input);
        return dfs(input,-1,0,new boolean[input.length],0);
    }

    public static int dfs(char[] input,int pre,int level,boolean[] used,int count){
        // 达到满足的字符串数
        if (level == n) {
            return ++count;
        }
        for (int i = 0; i < input.length; i++) {
            // 当前元素使用过
            if (used[i]) continue;
            if (pre >= 0 && input[i] == input[pre]) {
                continue;
            }
            if (i > 0 && input[i] == input[i - 1] && !used[i -1]) {
                continue;
            }
            used[i] = true;
            count = dfs(input,i,level + 1,used,count);
            used[i] = false;
        }
        return count;
    }
}
