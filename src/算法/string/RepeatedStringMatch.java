package 算法.string;


import java.util.ArrayList;
import java.util.List;

/**
 * 686. 重复叠加字符串匹配
 *
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 *
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 *
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 *
 * 注意:
 *
 *  A 与 B 字符串的长度在1和10000区间范围内。
 */
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
