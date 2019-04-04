package string;


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
