/**
 * 最大子数组和
 *
 * @Author: Xiaov
 * @Date: 2024/8/21 02:56
 */
public class Problem013 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        // 一个都不选
        int minSum = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            // 必须选一个，minSum只能是之前的
            res = Math.max(res, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return res;
    }

    // 分治
    public class MaxAreaInfo{
        public int lSum, rSum, mSum, allSum;

        public MaxAreaInfo(int lSum, int rSum, int mSum, int allSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.allSum = allSum;
        }
    }

    public int maxSubArrayFunc2(int[] nums) {
        return getMaxArea(nums, 0, nums.length - 1).mSum;
    }

    public MaxAreaInfo getMaxArea(int[] nums, int l, int r) {
        if (l == r) {
            return new MaxAreaInfo(nums[l], nums[l], nums[l], nums[l]);
        }
        int m = (l + r) >> 1;
        MaxAreaInfo lSub = getMaxArea(nums, l, m);
        MaxAreaInfo rSub = getMaxArea(nums, m + 1, r);
        return mergeMaxInfo(lSub, rSub);
    }

    public MaxAreaInfo mergeMaxInfo(MaxAreaInfo l, MaxAreaInfo r) {
        int allSum = l.allSum + r.allSum;
        int lSum = Math.max(l.lSum , l.allSum + r.lSum);
        int rSum = Math.max(r.rSum, l.rSum + r.allSum);
        int mSum = Math.max(l.rSum + r.lSum, Math.max(l.mSum, r.mSum));
        return new MaxAreaInfo(lSum, rSum, mSum, allSum);
    }
}
