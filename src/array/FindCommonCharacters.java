package array;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

    public static void main(String[] args) {
        // "bella","label","roller"
        // "cool","lock","cook"
        char b = 'b';

        String s = "abcdea";
//        System.out.println(s.contains("a"));
//        System.out.println(s.indexOf(b));
//        String i = s.substring(0, 1) + s.substring(2);
//        System.out.println(i);
        System.out.println(s.indexOf("a"));
        String[] A = {"bellal","labell","rollerl",};
        List<String> result = findCommonCharacters(A);
        System.out.println(result);

    }
    public static List<String> findCommonCharacters(String[] A){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < A[0].length(); i++) {
            Character temp = A[0].charAt(i);
            int count = 0;
            for (int j = 1; j < A.length; j++) {
                int index = A[j].indexOf(temp);
                if ( index!= -1){
                    A[j] = A[j].substring(0,index) +A[j].substring(index+1);
                    count++;
                }
            }
            if (count == A.length -1) {
                result.add(temp.toString());
            }
        }
        return result;
    }
}
