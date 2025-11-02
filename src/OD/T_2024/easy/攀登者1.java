package OD.T_2024.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-09-07
 * @Author：landaguo
 */
public class 攀登者1 {

    /**
     * 0,1,4,3,1,0,0,1,2,3,1,2,1,0
     * 3
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(input));
    }
    public static int getResult(int[] heights){
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftHeight = i -1 >=0 ? heights[i -1] : 0;
            int rightHeight = i + 1 < heights.length ? heights[i + 1] : 0;
            if (heights[i] > leftHeight && heights[i] > rightHeight) {
                ans++;
            }
        }
        return ans;
    }
}
