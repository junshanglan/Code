package OD.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-09
 * @Author：landaguo
 */
public class 悄悄话 {

    /**
     * 层序遍历
     * 0 9 20 -1 -1 15 7 -1 -1 -1 -1 3 2
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] times = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 记录题解
        int ans = 0;
        // 根节点的索引是0,索引队列
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        while (queue.size() > 0) {
            int fa = queue.removeFirst();
            int lch = fa * 2 +1;
            int rch = fa * 2 +2;
            boolean lch_exist = lch < times.length && times[lch] != -1?true:false;
            boolean rch_exist = rch < times.length && times[rch] != -1?true:false;
            // 若存在左子节点
            if (lch_exist) {
                times[lch] += times[fa];
                queue.addLast(lch);
            }
            // 若存在右子节点
            if (rch_exist) {
                times[rch] += times[fa];
                queue.addLast(rch);
            }
            // 若当前的fa节点为叶子节点，则记录耗时
            if (!lch_exist && !rch_exist) {
                ans = Math.max(ans,times[fa]);
            }
        }
        System.out.println(ans);

    }
}
