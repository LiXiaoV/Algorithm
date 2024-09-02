import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树
 *
 * @Author: Xiaov
 * @Date: 2024/9/3 02:33
 */
public class Problem039 {
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

    // 递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right == null || left == null && right != null || left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    // 迭代
    public boolean isSymmetricFunc2(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Deque<TreeNode> tmpQueue = new LinkedList<>();
        boolean notAllNullFlag = true;
        while (!queue.isEmpty() && notAllNullFlag) {
            int size = queue.size();
            notAllNullFlag = false;
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                tmpQueue.offer(treeNode);
                if (treeNode != null) {
                    queue.offer(treeNode.left);
                    queue.offer(treeNode.right);
                    if (treeNode.left != null || treeNode.right != null) {
                        notAllNullFlag = true;
                    }
                }
                size--;
            }
            if (!isSymmetric(tmpQueue)) return false;
            tmpQueue.clear();
        }
        return true;
    }

    public boolean isSymmetric(Deque<TreeNode> queue) {
        if (queue.size() < 2) return true;
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode last = queue.removeLast();
            if (first == null && last == null) continue;
            if (first == null && last != null || first != null && last == null || first.val != last.val) {
                return false;
            }
        }
        return true;
    }

}
