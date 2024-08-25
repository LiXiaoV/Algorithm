/**
 * 缺失的第一个正数
 *
 * @Author: Xiaov
 * @Date: 2024/8/26 00:41
 */
public class Problem017 {
    public int firstMissingPositive(int[] nums) {
        int numSize = nums.length;
        for (int i = 0; i < numSize; i++) {
            while (nums[i] > 0 && nums[i] <= numSize && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < numSize; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return numSize + 1;
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public int firstMissingPositiveFunc2(int[] nums) {
        int numSize = nums.length;
        for (int i = 0; i < numSize; i++) {
            if (nums[i] <= 0) nums[i] = numSize + 1;
        }
        for (int i = 0; i < numSize; i++) {
            int num = Math.abs(nums[i]);
            if (num <= numSize) {
                int index = num - 1;
                nums[index] = -Math.abs(nums[index]);
            }
        }
        for (int i = 0; i < numSize; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return numSize + 1;
    }


}
