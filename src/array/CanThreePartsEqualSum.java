package array;

/**
 * 1013. 将数组分成和相等的三个部分
 *
 *给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 *
 *
 * 示例 1：
 *
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 */
public class CanThreePartsEqualSum {

    public static void main(String[] args) {
        // [0,2,1,-6,6,-7,9,1,2,0,1]
        // [3,3,6,5,-2,2,5,1,-9,4]
        // 0,2,1,-6,6,7,9,-1,2,0,1
        // [18,12,-18,18,-19,-1,10,10]
        int[] A = {0,2,1,-6,6,-7,9,1,2,0,1};
        boolean b = canThreePartsEqualSum(A);
        System.out.println(b);
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0)
            return false;
        int oneThird = sum/3;
        int first = 0,second = 0,third = 0;
        for (int i = 0; i < A.length; i++) {
            if (first != oneThird) {
                first +=A[i];
            }else if (second != oneThird) {
                second +=A[i];
            }else if(third != oneThird){
                third += A[i];
            }
        }
        return (first == second && second == third)?true:false;
    }
}
