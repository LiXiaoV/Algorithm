/**
 * 接雨水
 *
 * @Author: Xiaov
 * @Date: 2024/8/14 04:06
 */
public class Problem007 {
    public static int trap(int[] height) {
        if (height.length < 3) return 0;
        int numSize = height.length;
        int[] leftMax = new int[numSize];
        leftMax[0] = height[0];
        for (int i = 1; i < numSize; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[numSize];
        rightMax[numSize - 1] = height[numSize - 1];
        for (int i = numSize - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1] , height[i]);
        }
        int res = 0;
        for (int i = 0; i < numSize; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    // 空间复杂福o(1) 的方法
    // 当i < j 时， leftMax[i] <= leftMax[j] ,rightMax[left] >= rightMax[right]
    // 所以，当leftMax[i] < rightMax[j] 时，leftMax[i] < rightMax[j] < rightMax[i],此时i处的雨水能算出
    // 当leftMax[i] > rightMax[j] 时，rightMax[j] < 当leftMax[i] < leftMax[j],此时j处的雨水能算出
    // 好比左右两个拳击手，输的下去结账
    public static int trapFunc2(int[] height) {
        if (height.length < 3) return 0;
        int left = 0, right = height.length - 1 , res = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            }else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trapFunc2(height);
        System.out.println("res = " + res);
    }
}
