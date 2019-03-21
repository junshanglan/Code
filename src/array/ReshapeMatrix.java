package array;


import java.util.Arrays;

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
