package leetcode.hot100.双指针;

public class 盛最多水的容器11 {
    public  int maxArea(int[] height) {
        int res = 0;
        int left = 0,right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = h * (right - left);
            res = Math.max(res,area);
            if (height[left] >= height[right] ){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }
}
