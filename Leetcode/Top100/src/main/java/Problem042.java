/**
 * 将有序数组转换为二叉搜索树
 *
 * @Author: Xiaov
 * @Date: 2024/9/3 03:49
 */
public class Problem042 {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = (left + right) >> 1;
        return new TreeNode(nums[mid], sortedArrayToBST(nums, left, mid - 1),
                sortedArrayToBST(nums, mid + 1, right));
    }
}
