package string;


import java.util.ArrayList;
import java.util.List;

public class RepeatedStringMatch {

    public static void main(String[] args) {
        //  A = "abcd"，B = "cdabcdab"。  "abdfdcfdfdafc"
        // "aaac"
        //"aac"
        String A = "aaac",B = "aac";
        int i = repeatedStringMatch(A, B);
        System.out.println(i);
    }
    public static int repeatedStringMatch(String A, String B) {
        char startB = B.charAt(0);
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == startB){
                indexList.add(i);
            }
        }
        int count = 1;
        int result = -1;
        for (int i = 0; i < indexList.size(); i++) {
            String tempStr = A.substring(indexList.get(i));
            while (tempStr.length() < B.length()) {
                tempStr+=A;
                count++;
            }
            int j = 0;
            for (; j < B.length(); j++) {
                if (B.charAt(j) != tempStr.charAt(j)) {
                    count = 1;
                    break;
                }
            }
            if (j == B.length()){
                result = count;
                break;
            }
        }
        return result;
    }
}
