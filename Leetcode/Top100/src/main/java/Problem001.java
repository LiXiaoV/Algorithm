import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 两数之和
 *
 * @Author: Xiaov
 * @Date: 2024/8/5 03:25
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
        System.out.println("res = " + JSON.toJSONString(res));
    }
}
