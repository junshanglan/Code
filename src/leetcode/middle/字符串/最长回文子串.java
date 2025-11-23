package leetcode.middle.字符串;

public class 最长回文子串 {

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String res = s.charAt(0) + "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                StringBuilder substring = new StringBuilder(s.substring(i, j + 1));
                if (substring.length() > res.length()) {
                    StringBuilder reverse = new StringBuilder(substring);
                    if (substring.toString().equals(reverse.reverse().toString())){
                        res = substring.toString();
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        StringBuilder abab = new StringBuilder("abab");
        System.out.println(abab.reverse().equals("abab"));
    }

    /**
     * 
     */
//    public static String longestPalindrome(String s) {
//        if (s.length() < 2) {
//            return s;
//        }
//        String res = s.charAt(0) + "";
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j < s.length(); j++) {
//                StringBuilder substring = new StringBuilder(s.substring(i, j + 1));
//                if (substring.length() > res.length()) {
//                    StringBuilder reverse = new StringBuilder(substring);
//                    if (substring.toString().equals(reverse.reverse().toString())){
//                        res = substring.toString();
//                    }
//                }
//            }
//        }
//        return res;
//    }
}
