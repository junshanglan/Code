package array;


public class MonotonicArray {


    public static void main(String[] args) {
        // [6,5,4,4]
        int[] A = {6,5,4,4};
        boolean result = isMonotonic(A);
        System.out.println(result);
    }

    public static boolean isMonotonic(int[] A) {
        int flag = A[0] - A[A.length-1];
        if (flag > 0) {
            for (int i = 0; i < A.length-1; i++) {
                if (A[i] < A[i+1])
                    return false;
            }
        }else if(flag < 0) {
            for (int i = 0; i < A.length-1; i++) {
                if (A[i+1] < A[i])
                    return false;
            }
        }else {
            for (int i = 0; i < A.length-1; i++) {
                if (A[i+1] != A[i])
                    return false;
            }
        }
        return true;
    }


}
