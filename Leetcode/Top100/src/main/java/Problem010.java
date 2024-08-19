import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组
 *
 * @Author: Xiaov
 * @Date: 2024/8/20 02:15
 */
public class Problem010 {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        // sum[0...i] - sum[0...j] == 时,如果sum[0...j] == 0,那么和的次数应该+1
        sumCountMap.put(0, 1);
        int preSum = 0, res = 0;
        for (int num : nums) {
            preSum += num;
            res += sumCountMap.getOrDefault(preSum - k, 0);
            sumCountMap.put(preSum, sumCountMap.getOrDefault(preSum , 0) + 1);
        }
        return res;
    }
}
