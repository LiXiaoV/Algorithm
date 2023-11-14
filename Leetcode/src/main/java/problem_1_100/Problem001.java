package problem_1_100;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Xiaov
 * @Date: 2023/11/15 03:41
 */
@Slf4j
public class Problem001 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIndexMap.containsKey(target - nums[i]))
                return new int[]{numIndexMap.get(target - nums[i]), i};
            numIndexMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("res = " + Arrays.toString(res));
    }
}
