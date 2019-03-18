package array;

import util.CommonUtil;

public class SortedSquares {

    public static void main(String[] args) {
        int[] arr = {-4,-12,0,7,6,9,10,1,13};
        int[] result = sortedSquares(arr);
        CommonUtil.forEach(result);
    }

    public static int[] sortedSquares(int[] arr){
        int[] resultArr = new int[arr.length];
        int i,j;
        for (i = 0;i<arr.length;i++) {
            int temp = arr[i] * arr[i];
            if ( i == 0) {
                resultArr[i] = temp;
            }else{
                resultArr[i] = temp;
                if (resultArr[i] < resultArr[i-1]) {
                    for (j = i-1;j>=0 && temp <resultArr[j];j--) {
                        resultArr[j+1] = resultArr[j];
                    }
                    resultArr[j+1] = temp;
                }
            }
        }
        return resultArr;
    }
}
