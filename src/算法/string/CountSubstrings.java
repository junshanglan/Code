package 算法.string;

/**
 * 647. 回文子串
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 */
public class CountSubstrings {

    public static void main(String[] args) {
        //  A = "aaaaaaabc", B = "aaaaaaacb"
        String s = "aaba";
        int i = countSubstrings(s);
        System.out.println(i);
    }

    public static int countSubstrings(String s) {
        int count = s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                int temp1 = i,temp2 = j;
                for (; temp2> temp1  ;temp1++,temp2--) {
                    if (s.charAt(temp1) != s.charAt(temp2))
                        break;
                }
                if (temp1 >= temp2)
                    count++;
            }
        }
        return count;
    }
}
