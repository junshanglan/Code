package string;


import java.util.ArrayList;
import java.util.List;

public class Compress {

    public static void main(String[] args) {
        //  {'a','a','b','b','c','c','c'};
        // ['a','b','b','b','b','b','b','b','b','b','b','b','b']
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress = compress(chars);
        System.out.println(compress);
    }

    public static int compress(char[] chars) {
        char tempChar ;
        int i = 0,index = -1,j;
        while (i < chars.length) {
            tempChar = chars[i];
            chars[++index] = tempChar;
            Integer count = 1;
            for (j = i+1; j < chars.length; j++) {
                if (tempChar != chars[j]){
                    i = j;
                    break;
                }
                count++;
            }
            if (count != 1){
                String countTemp = count.toString();
                for (int k = 0; k < countTemp.length(); k++) {
                    chars[++index] = countTemp.charAt(k);
                }
            }
            if (j == chars.length)
                break;
        }
        return ++index;
    }
}
