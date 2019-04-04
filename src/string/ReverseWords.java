package string;


public class ReverseWords {
    public static void main(String[] args) {
        // "Let's take LeetCode contest"
        String s = "Let's take LeetCode contest";
        StringBuilder s2 = new StringBuilder(s);
        s2.reverse();
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
    // 目前最优解
    public static String reverseWords(String s) {
        char[] rev = s.toCharArray();
        int head = 0, tail = 0;
        while(tail<s.length()){
            while(tail<s.length()&&s.charAt(tail)!=' '){
                tail++;
            }
            int i = head,j=tail - 1;
            while(i < j){
                char temp = rev[i];
                rev[i++] = rev[j];
                rev[j--] = temp;
            }
            tail += 1;
            head = tail;
        }
        return new String(rev);
    }

    public static String reverseWords1(String s) {
        int begin = 0;
        StringBuilder s1 = new StringBuilder(s);
        while (s1.indexOf(" ",begin) != -1 || begin < s1.length()) {
            int end = s1.indexOf(" ",begin);
            if (end == -1)
                end = s1.length();
            int j = begin,k = end-1;
            while (k > j) {
                char temp = s1.charAt(j);
                s1.setCharAt(j,s1.charAt(k));
                s1.setCharAt(k,temp);
                j++;
                k--;
            }
            begin = end + 1;
        }
        return new String(s1);
    }

	/*public static String reverseWords(String s) {
		String[] strArr = s.split(" ");
		for (int k =0;k<strArr.length;k++) {
			int i = 0,j = strArr[k].length()-1;
			char[] chars = strArr[k].toCharArray();
			while (j > i) {
				char tempChar = chars[i];
				chars[i] = chars[j];
				chars[j] = tempChar;
				i++;
				j--;
			}
			String s1 = new String(chars);
			strArr[k] = s1;
		}
		String result = "";
		for (int i = 0; i < strArr.length; i++) {
			result += " " + strArr[i];
		}
		return result.substring(1);
	}*/
}
