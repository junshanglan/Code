package leetcode.middle.字符串;

public class 最长回文子串 {
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (substring.length() > res.length()) {
                    if (reverseEqual(substring)) {
                        res = substring;
                    }
                }
            }
        }
        return res;
    }

    private static boolean reverseEqual(String s){
        int left = 0,right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = longestPalindrome("ab");
        System.out.println(a);
    }
}
