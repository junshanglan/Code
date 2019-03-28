package array;

import java.util.Arrays;

public class FairCandySwap {

    public static void main(String[] args) {
        // A = [1,2,5], B = [2,4] return [5,4]
        int[] A = {1,1};
        int[] B = {2,2};
        int[] result = fairCandySwap(A, B);
        System.out.println(Arrays.toString(result));
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        int[] result = new int[2];
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        if (sumA == sumB) {
            return result;
        }else {
            int targetNum = (sumA + sumB)/2;
            if ((sumA - targetNum) > 0) {
                int targetDiff = sumA -targetNum;
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < B.length; j++) {
                        if ( (A[i] - B[j]) == targetDiff ) {
                            result[0] = A[i];
                            result[1] = B[j];
                            return result;
                        }
                    }
                }
            } else {
                int targetDiff = sumB -targetNum;
                for (int i = 0; i < B.length; i++) {
                    for (int j = 0; j <A.length; j++) {
                        if ((B[i] - A[j]) == targetDiff) {
                            result[0] = A[j];
                            result[1] = B[i];
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }
}
