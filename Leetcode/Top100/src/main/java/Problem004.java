/**
 * 移动0
 *
 * @Author: Xiaov
 * @Date: 2024/8/13 02:08
 */
public class Problem004 {
    public void moveZeroes(int[] nums) {
        int notZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[notZeroIndex++] = nums[i];
            }
        }
        for (int i = notZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesFunc2(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, zeroIndex, i);
                zeroIndex++;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
