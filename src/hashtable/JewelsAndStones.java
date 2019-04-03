package hashtable;


public class JewelsAndStones {

    public static void main(String[] args) {
        // J = "aA", S = "aAAbbbbaaaa"
        String J = "aA", S = "aAAbbbbaaaa";
        int i = numJewelsInStones(J, S);
        System.out.println(i);
    }

    public static int numJewelsInStones(String J, String S) {
        int num = 0;
        for (int i = 0; i < J.length(); i++) {
            char jewel =J.charAt(i);
            for (int j = 0; j < S.length(); j++) {
                if (jewel == S.charAt(j))
                    num++;
            }
        }
        return num;
    }
}
