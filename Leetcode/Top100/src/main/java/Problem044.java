import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 二叉搜索树中第 K 小的元素
 *
 * @Author: Xiaov
 * @Date: 2024/9/4 02:43
 */
public class Problem044 {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return  -1;
    }

    // 大顶堆取最小的的第n个
    public int kthSmallestFunc2(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        PriorityQueue<TreeNode> maxHeap = new PriorityQueue<>(k, new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o2.val - o1.val;
            }
        });
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k >= 0) {
                maxHeap.offer(root);
            } else {
                if (root.val < maxHeap.peek().val) {
                    maxHeap.poll();
                    maxHeap.offer(root);
                }
            }
            root = root.right;
        }
        return  maxHeap.peek().val;
    }
}
