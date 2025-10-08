package 算法.dynamicprogramming;

/**
 * 746.使用最小花费爬楼梯（Min Cost Climbing Stairs）
 *
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        //输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
        //输出: 6
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int i = minCostClimbingStairs(cost);
        System.out.println(i);
    }

    public static int minCostClimbingStairs(int[] cost) {
        /*int len = cost.length;
        if(len==2) {
            return Math.min(cost[0], cost[1]);
        }
        int [] arr = new int[len+1];
        arr[0] = cost[0];
        arr[1] = cost[1];
        for(int i=2;i <= len;i++){
            int curr = 0;
            if (i != len) {
                curr = cost[i];
            }
            arr[i] = Math.min(arr[i-2],arr[i-1])+curr;
        }
        return arr[len];*/
        // 状态方程： dp[i] = min( dp[i-2], dp[i-1] ) + cost[i];
        // 优化
        if (cost.length <=1) {
            return cost.length == 0? 0 :cost[1];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2]) +cost[i];
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}
