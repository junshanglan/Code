package 算法.array;

/**
 * 509. 斐波那契数
 *
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 */
public class Fib {

    public static void main(String[] args) {
        //1,1,2,3,5,8,13,21,34
        //30  832040
        int fib = fib(1);
        System.out.println(fib);
    }
    public static int fib(int N){
		/*if (N == 0) {
			return 0;
		}else if (N == 1) {
			return 1;
		}else{
			return fib(N -1) +fib(N - 2);
		}*/

		/*if (N == 0) {
			return 0;
		} else if(N == 1){
			return 1;
		}else{
			List<Integer> data = new ArrayList<Integer>(){{
				add(1);
				add(1);
			}};
			for (int i = 2; i < N; i++) {
				int temp = data.get(i - 1) + data.get(i - 2);
				data.add(temp);
			}
			return data.get(data.size()-1);
		}*/
		// 最优解
        if (N == 0){
            return 0;
        }else if (N == 1) {
            return 1;
        }

        int fib1 = 0,fib2 = 1,temp = 0;
        for (int i = 2; i <= N ; i++) {
            temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;
        }
        return temp;
    }
}
