import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 *
 * @Author: Xiaov
 * @Date: 2024/9/4 03:11
 */
public class Problem045 {

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

    private List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if(--size == 0) {
                    res.add(treeNode.val);
                }
            }
        }
        return res;
    }

    public List<Integer> rightSideViewFunc2(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() <= depth) {
            res.add(root.val);
        } else {
            res.set(depth, root.val);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }


}
