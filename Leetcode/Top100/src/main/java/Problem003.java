import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长连续序列
 *
 * @Author: Xiaov
 * @Date: 2024/8/12 02:15
 */
public class Problem003 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestNumSetLength = 0;
        for (int num : nums) {
            // 判断当前数是不是连续数的起点，是起点才开始算
            // 算上if判断时间复杂度应该是O(2n - 多少个连续段)
            // 如果一个数是连续数的起点，那么它只在循环外层出现一次，如果一个数不是一个数的起点，那么它在循环内层和if判断中都出现一次
            // 假设数组长度为n，有m个连续段，那么循环总共计算，m + 2（n - m）= 2n - m
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int numSetLength = 1;
                while (numSet.contains(curNum + 1)) {
                    curNum += 1;
                    numSetLength += 1;
                }
                longestNumSetLength = Math.max(longestNumSetLength, numSetLength);
            }
        }
        return longestNumSetLength;
    }

    /**
     长度 = 左边 + 1 + 右边
     需实时保持左边长度与右边长度的正确值
     大的左边+右边 -> （左边、右边）本身又是求最大值
     初始状态就是左右两边都没有，为1
     */
    public int longestConsecutiveFunc2(int[] nums) {
        // 记录子序列两端点的
        Map<Integer, Integer> startEndSizeMap = new HashMap<>();
        int longestNumSetLength =  0;
        for (int num : nums) {
            // 已经算过了的就不算了，算新的
            if (!startEndSizeMap.containsKey(num)) {
                Integer leftSize = startEndSizeMap.getOrDefault(num - 1, 0);
                Integer rightSize = startEndSizeMap.getOrDefault(num + 1, 0);
                Integer curLength = leftSize + 1 + rightSize;
                longestNumSetLength = Math.max(longestNumSetLength, curLength);
                startEndSizeMap.put(num, curLength);
                startEndSizeMap.put(num - leftSize, curLength);
                startEndSizeMap.put(num + rightSize, curLength);
            }
        }
        return longestNumSetLength;
    }
}
