package 算法.dynamicprogramming;

/**
 *70.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs {

    public static void main(String[] args) {
        // 1,1  2,2  3,3  4,
        int i = climbStairs(10);
        System.out.println(i);
    }

    public static int climbStairs(int n){
        // 不是最优解，时间，空间复杂度都很大
		/*if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else  {
			 return climbStairs(n-1) + climbStairs(n-2);
		}*/

        // 迭代
		/*if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else {
			int[] result = new int[n];
			result[0] = 1;
			result[1] = 2;
			for (int i = 2; i < n; i++) {
				result[i] = result[i-1] + result[i-2];
			}
			return result[n-1];
		}*/
        // 使用迭代，但减少空间复杂度
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else {
            int first = 1,second = 2,temp = 0;
            for (int i = 2; i < n; i++) {
                temp = first + second;
                first = second;
                second = temp;
            }
            return temp;
        }
    }
}
