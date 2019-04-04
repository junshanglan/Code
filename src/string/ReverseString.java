package string;


public class ReverseString {
    public static void main(String[] args) {
        // ["h","e","l","l","o"]
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);

    }

    public static void reverseString(char[] s) {
        int i = 0,j = s.length-1;
        while (j > i) {
            char temp = s[i];
            s[i] =s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
