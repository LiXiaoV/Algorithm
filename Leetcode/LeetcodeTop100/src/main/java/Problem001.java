import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author: Xiaov
 * @Date: 2024/8/5 02:26
 */
public class Problem001 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = Maps.newHashMap();
        for (int i = 0; i < nums.length; i++) {
            if (valueIndexMap.containsKey(target - nums[i])) {
                return new int[]{valueIndexMap.get(target - nums[i]) ,i};
            }
            valueIndexMap.put(nums[i], i);
        }
        return new int[]{0};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        System.out.println("res = " + res);
    }
}
