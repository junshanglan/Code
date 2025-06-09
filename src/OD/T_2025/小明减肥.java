package OD.T_2025;

import java.util.Scanner;

/**
 * @Description：
 * @Date：2025-05-28
 * @Author：landaguo
 */
public class 小明减肥 {

    static int count = 0;

    static int n,t,k;
    static int[] calories;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 可选运动数
        n = scanner.nextInt();
        // 卡路里总和
        t = scanner.nextInt();
        // 选择运动数
        k = scanner.nextInt();
        calories = new int[n];
        for (int i = 0; i < n; i++) {
            calories[i] = scanner.nextInt();
        }
        backtrack(0,0,0);
        System.out.println(count);
    }

    /**
     * @param index 当前下标
     * @param selected  选择的个数
     * @param sum  总和
     */
    private static void backtrack(int index,int selected,int sum){
        if (selected == k) {
            if (sum == t) {
                count++;
            }
            return;
        }
        if (index >= n || selected >= k) {
            return;
        }
        // 选择当前元素计算
        backtrack(index+1,selected + 1,sum + calories[index]);
        backtrack(index+1,selected,sum);
    }
}
