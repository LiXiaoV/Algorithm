import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @Author: Xiaov
 * @Date: 2024/8/21 03:43
 */
public class Problem014 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= left && interval[1] <= right) continue;
            if (interval[0] > right) {
                res.add(new int[]{left, right});
                left = interval[0];
            }
            right = interval[1];
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }
}
