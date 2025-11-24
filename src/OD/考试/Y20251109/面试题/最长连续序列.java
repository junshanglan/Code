package OD.考试.Y20251109.面试题;

import java.util.HashSet;

public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,201,202,203,204,205,1,3,2,5,6,7,8};
        int res = findContinueSeq(nums);
        System.out.println(res);

    }

    public static int findContinueSeq(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int ans = 1;
        int tmp = 1;
        for (Integer item : set) {
            int a = item - 1;
            int b = item + 1;
            if (set.contains(a)) {
                dfs(set,a - 1,tmp++);
            }else if (set.contains(b)){
                tmp++;
            }else {
                tmp = 1;
            }

        }
        return ans;
    }
    public static int  dfs(HashSet<Integer> set,int target,int tmp){
        if (set.contains(target)) {
            tmp++;
            set.remove(target);
        }
        return tmp;
    }
//    public static int findContinueSeq(int[] nums){
//        if (nums.length == 0) {
//            return 0;
//        }
//        int ans = 1;
//        Arrays.sort(nums);
//        int tmp = 1;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i + 1] - 1){
//                tmp++;
//            }else{
//                ans = Math.max(ans,tmp);
//                tmp = 1;
//            }
//        }
//        ans = Math.max(ans,tmp);
//        return ans;
//    }
}
