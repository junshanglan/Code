package string;


import java.util.HashSet;

public class UniqueMorseRepresentations {

    public static void main(String[] args) {
        // [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        //  words = ["gin", "zen", "gig", "msg"]
        String[] words = {"gin", "zen", "gig", "msg"};
        int i = uniqueMorseRepresentations(words);
        System.out.println(i);
    }


    public static int uniqueMorseRepresentations(String[] words) {
        String[] str = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet result = new HashSet();
        for (int i = 0; i < words.length; i++) {
            String tempMap = "";
            for (int j = 0; j < words[i].length(); j++) {
                int temp = (int) words[i].charAt(j) - 97;
                tempMap += str[temp];
            }
            result.add(tempMap);
        }
        return result.size();
    }

}
