import com.alibaba.fastjson2.JSON;

import java.util.*;

/**
 * 滑动窗口最大值
 *
 * @Author: Xiaov
 * @Date: 2024/8/20 02:39
 */
public class Problem011 {
    // 大顶堆
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) return new int[]{};
        List<Integer> resArr = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        resArr.add(maxHeap.peek());

        for (int i = k; i < nums.length; i++) {
            maxHeap.remove(nums[i - k]);
            maxHeap.offer(nums[i]);
            resArr.add(maxHeap.peek());
        }
        return resArr.stream().mapToInt(Integer::intValue).toArray();
    }

    // 维持一个比当前数大的队列
    public static int[] maxSlidingWindowFunc2(int[] nums, int k) {
        if (nums.length < k) return new int[]{};
        List<Integer> resArr = new ArrayList<>();
        Deque<Integer> maxQueue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 移出队列头
            if (i >= k && nums[i - k] == maxQueue.peekFirst()) {
                maxQueue.removeFirst();
            }
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[i]) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(nums[i]);
            if (i >= k - 1) {
                resArr.add(maxQueue.peekFirst());
            }
        }
        return resArr.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1};
        int[] maxSlidingWindow = maxSlidingWindowFunc2(nums, 1);
        System.out.println("maxSlidingWindow = " + JSON.toJSON(maxSlidingWindow));
    }
}
