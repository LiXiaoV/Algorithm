import java.util.*;

/**
 * 三数之和
 *
 * @Author: Xiaov
 * @Date: 2024/8/14 02:34
 */
public class Problem006 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> chosenNumsStr = new HashSet<>();
        for (int i = 1; i < nums.length - 1; i++) {
            int left = 0, right = nums.length - 1;
            while (i > left && i < right) {
                int tmpSum = nums[left] + nums[right] + nums[i];
                if (tmpSum == 0) {
                    String key = String.valueOf(nums[left]) + nums[i] + nums[right];
                    if (!chosenNumsStr.contains(key)) {
                        res.add(Arrays.asList(nums[left] , nums[i], nums[right]));
                        chosenNumsStr.add(key);
                    }
                    left++;
                    right--;
                } else if(tmpSum < 0) left++;
                else right--;
            }
        }
        return res;
    }

    /*
    * 原来这道题的难点在去重，fuck
    * */
    public List<List<Integer>> threeSumFunc2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmpSum = nums[i] + nums[left] + nums[right];
                // 能移动了再移，要不然有像【-2,1,1】这种实例，直接移了有问题
                if (tmpSum == 0) {
                    res.add(Arrays.asList(nums[i] , nums[left], nums[right]));
                    while (left < right && nums[right] == nums[--right]);
                    while (left < right && nums[left] == nums[++left]);
                } else if(tmpSum < 0) {
                    while (left < right && nums[left] == nums[++left]);
                }else {
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }
        return res;
    }
}
