/**
 * 盛最多水的容器
 *
 * @Author: Xiaov
 * @Date: 2024/8/13 02:46
 */
public class Problem005 {
    public static int maxArea(int[] height) {
        if (height.length < 1){
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            // 两者一样大，还是有变大的可能性，要继续内移
            //比如【5，,25，,24，,5】
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) right--;
            else left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(nums);
        System.out.println("maxArea = " + maxArea);
    }

}
