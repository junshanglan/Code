package leetcode.middle.数组;

public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (left < right) {
            int area = Math.min(height[left],height[right]) * (right - left);
            res = Math.max(res,area);
            if (height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
