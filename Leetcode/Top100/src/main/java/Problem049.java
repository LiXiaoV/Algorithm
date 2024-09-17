import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 二叉树的最近公共祖先
 *
 * @Author: Xiaov
 * @Date: 2024/9/18 04:43
 */
public class Problem049 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, Integer> treeIndexMap = preOrder(root);
        while (treeIndexMap.get(root) > treeIndexMap.get(p) && treeIndexMap.get(root) > treeIndexMap.get(q)
                || treeIndexMap.get(root) < treeIndexMap.get(p) && treeIndexMap.get(root) < treeIndexMap.get(q)) {
            if (treeIndexMap.get(root) > treeIndexMap.get(p) && treeIndexMap.get(root) > treeIndexMap.get(q)) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    private HashMap<TreeNode, Integer> preOrder(TreeNode root) {
        HashMap<TreeNode, Integer> treeIndexMap = new HashMap<>();
        if (root == null) {
            return treeIndexMap;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            treeIndexMap.put(treeNode, treeIndexMap.size());
            root = treeNode.right;
        }
        return treeIndexMap;
    }

    // 递归
    public TreeNode lowestCommonAncestorFunc2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorFunc2(root.left, p, q);
        TreeNode right = lowestCommonAncestorFunc2(root.right, p, q);
        if (null == left) return right;
        if (null == right) return left;
        return root;
    }


}
