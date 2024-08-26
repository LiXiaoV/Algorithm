/**
 * 搜索二维矩阵 II
 *
 * @Author: Xiaov
 * @Date: 2024/8/26 05:39
 */
public class Problem021 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        for (int[] nums : matrix) {
            if (midSearch(nums, target) >= 0) return true;
        }
        return false;
    }

    public int midSearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            } else if (midNum > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public boolean searchMatrixFunc2(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        int top = 0, right = col - 1;
        while (top < row && right >= 0) {
            int curVal = matrix[top][right];
            if (curVal == target) {
                return true;
            } else if (curVal > target) {
                right--;
            } else {
                top++;
            }
        }
        return false;
    }
}
