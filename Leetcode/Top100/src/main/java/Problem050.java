/**
 * 二叉树中的最大路径和
 *
 * @Author: Xiaov
 * @Date: 2024/9/18 05:32
 */
public class Problem050 {
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

    private int globalMaxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int containSelfMaxPath = dfs(root.left, root.val, root.val) + dfs(root.right, root.val, root.val) - root.val;
        int leftMaxPath = root.val;
        if (root.left != null) {
            leftMaxPath = maxPathSum(root.left);
        }

        int rightMaxPath = root.val;
        if (root.right != null) {
            rightMaxPath = maxPathSum(root.right);
        }
        return Math.max(containSelfMaxPath, Math.max(leftMaxPath, rightMaxPath));
    }

    // 带有某个节点的最大路径和
    private int dfs(TreeNode node, int pre, int maxPath) {
        if (node == null) return maxPath;
        maxPath = Math.max(maxPath, pre + node.val);
        int leftMaxPath = dfs(node.left, pre + node.val, maxPath);
        int rightMaxPath = dfs(node.right, pre + node.val, maxPath);
        return Math.max(leftMaxPath, rightMaxPath);
    }

    public int maxPathSumFunc2(TreeNode root) {
        maxGain(root);
        return globalMaxPath;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        int leftMaxGain = Math.max(maxGain(node.left), 0);
        int rightMaxGain = Math.max(maxGain(node.right), 0);
        int curMaxPath = node.val + leftMaxGain + rightMaxGain;
        globalMaxPath = Math.max(curMaxPath, globalMaxPath);
        return node.val + Math.max(leftMaxGain, rightMaxGain);
    }
}
