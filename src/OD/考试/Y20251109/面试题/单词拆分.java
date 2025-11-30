package OD.考试.Y20251109.面试题;

import java.util.List;

public class 单词拆分 {


    /**
     * s = "leetcode", wordDict = ["leet", "code"]
     *
     *  s = "applepenapple", wordDict = ["apple", "pen"]
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        String tmp = s;
        int index = 0;
        boolean flag = true;
        while (flag){
            for (int i = 0; i < wordDict.size(); i++) {
                String item = wordDict.get(i);
                if (!tmp.contains(item) && tmp.length() > 0) {
                    flag =  false;
                }
                if (item.length() > tmp.length()){
                    continue;
                }
                if (tmp.startsWith(item)){
                    tmp = tmp.substring(item.length());
                    index = index + item.length();
                    break;
                }
            }
        }
        if (tmp.length() == 0 ){
            return true;
        }
        return false;
    }

}
