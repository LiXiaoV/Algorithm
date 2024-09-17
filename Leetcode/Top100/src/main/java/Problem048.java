import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和 III
 *
 * @Author: Xiaov
 * @Date: 2024/9/18 01:50
 */
public class Problem048 {
    public static class TreeNode{
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

    public static int pathSum(TreeNode root, int targetSum) {
        if (null == root) return 0;
        return calculateSum(root, targetSum)
                + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    // 算上当前节点有多少个sum
    private static int calculateSum(TreeNode root, long targetSum) {
        int res = 0;
        if (root == null) return 0;
        if (root.val == targetSum) res++;
        res += calculateSum(root.left, targetSum - root.val);
        res += calculateSum(root.right, targetSum - root.val);
        return res;
    }

    // 前缀树
    public int pathSumFunc2(TreeNode root, int targetSum) {
        Map<Long,Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        int res = dfs(root, prefix, 0, targetSum);
        return targetSum == 0 ? res - 1 : res;
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, long pre, int targetSum) {
        if (root == null) return 0;
        Long curr = pre + root.val;
        // 为什么先拿后放，假设target是0，root是1的情况，只有一个1，刚放进去1，再拿1，还拿到了，
        // 避免update之后的prefix影响原有的前缀树逻辑
        int res = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        res += dfs(root.left, prefix, curr, targetSum);
        res += dfs(root.right, prefix, curr, targetSum);

        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return res;
    }


    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4, null, treeNode5);
        TreeNode treeNode3 = new TreeNode(3, null, treeNode4);
        TreeNode treeNode2 = new, TreeNode(2, null, treeNode3);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);
        int pathSum = pathSum(treeNode1, 3);
        System.out.println("pathSum = " + pathSum);
    }
}
