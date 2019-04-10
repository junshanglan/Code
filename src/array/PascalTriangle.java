package array;


import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generate(2));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i ; j++) {
                if (j == 0 || i == j)
                    list.add(1);
                else {
                    list.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
                }
            }

            result.add(list);
        }
        return result;
    }
}
