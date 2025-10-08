package 算法.greddy;

/**
 *122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 */
public class MaxProfitII {

    public static void main(String[] args) {
        // [7,1,5,3,6,4]  {1,2,4,8}
        int[] prices = {1,2,4,8};
        int i = maxProfitII(prices);
        System.out.println(i);
    }
    // TODO 这道题的意思有点不太明确
    public static int maxProfitII(int[] prices) {
        if (prices.length == 0)
            return 0;
        int result = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i+1]) {
                result+=prices[i+1] - prices[i];
            }
        }
        return result;

    }
}
