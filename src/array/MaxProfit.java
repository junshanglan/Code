package array;


public class MaxProfit {

    public static void main(String[] args) {
        // [7,1,5,3,6,4]
        int[] prices = {7,1,5,3,6,4,10};
        int i = maxProfit(prices);
        System.out.println(i);

    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min =  prices[i];
            }
            if ((prices[i] - min) > max) {
                max = prices[i] -min;
            }
        }
        return max;
    }
    /*public static void main(String[] args) {
        // [7,1,5,3,6,4]
        int[] prices = {1,2};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int diff = 0;
        for (int i = 0; i < prices.length -1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                diff = prices[j] -prices[i];
                if (max < diff) {
                    max = diff;
                }
            }
        }
        return max;
    }*/
}
