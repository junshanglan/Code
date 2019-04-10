package string;


import java.util.ArrayList;
import java.util.List;

/**
 * 859. 亲密字符串
 *
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 *
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 *
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 *
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 *
 * 输入： A = "", B = "aa"
 * 输出： false
 */
public class BuddyStrings {

    public static void main(String[] args) {
        //  A = "aaaaaaabc", B = "aaaaaaacb"
        //"abab"
        //"abab"
        String A = "abab", B = "abab";
        A.equals(B);
        boolean result = buddyStrings(A, B);
        System.out.println(result);
    }

    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) // 长度不相等
            return false;
        if (A.equals(B)) {  // 两个字符串相等
            for (int i = 0; i < A.length(); i++) {
                Character c = A.charAt(i);
                String substring = A.substring(i + 1);
                boolean result = substring.contains(c.toString());
                if (result) {
                    return true;
                }
                /*for (int j = i+1; j < A.length(); j++) {
                    if (A.charAt(i) == A.charAt(j)){
                        return true;
                    }
                }*/
            }
            return false;
        }
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if ( A.charAt(i) != B.charAt(i)) {
                index.add(i);
            }
        }
        if (index.size() != 2)
            return false;
        else {
            char[] chars = A.toCharArray();
            char temp = chars[index.get(0)];
            chars[index.get(0)] = chars[index.get(1)];
            chars[index.get(1)] = temp;
            String s = new String(chars);
            System.out.println(s);
            if (s.equals(B)){
                return true;
            }
        }
        return false;
    }
}
