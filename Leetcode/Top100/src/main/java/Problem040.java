/**
 * 二叉树的直径
 *
 * @Author: Xiaov
 * @Date: 2024/9/3 03:09
 */
public class Problem040 {
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
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        res = 1;
        maxHeight(root);
        // 直径是最大节点数 - 1
        return res - 1;
    }

    public int maxHeight(TreeNode root) {
        if (root == null) return 0;
        int leftH = maxHeight(root.left);
        int rightH = maxHeight(root.right);
        // 计算最大节点数
        res = Math.max(res, leftH + rightH + 1);
        return Math.max(leftH, rightH) + 1;
    }
}
