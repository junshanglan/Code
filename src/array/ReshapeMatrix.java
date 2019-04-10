package array;


import java.util.Arrays;

/**
 * 566. 重塑矩阵
 *
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 示例 2:
 *
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 */
public class ReshapeMatrix {

    public static void main(String[] args) {
        //[[1,2],[3,4],[5,6],[7,8]]
        int[][] nums = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        int[][] result = reshapeMatrix(nums, 2, 5);
        for (int[] temp :result) {
            System.out.println(Arrays.toString(temp));
        }

    }

    public static int[][] reshapeMatrix(int[][] nums, int r, int c){
        long begin = System.nanoTime();
        int line = nums.length; //行
        int list = nums[0].length; //列
        if ((r * c != line * list) || (r == line && c == list)) {
            return nums;
        }else {
            int row =  0,col = 0;

            int[][] newArr = new int[r][c];
            for (int i = 0; i < line; i++) {
                for (int j = 0; j < list; j++) {
                    newArr[row][col] = nums[i][j];
                    col++;
                    if (col%c == 0) {
                        row++;
                        col = 0;
                    }
                }
            }
            long end = System.nanoTime();
            System.out.println("耗时：" + (end - begin) );
            return newArr;
        }
    }
}
