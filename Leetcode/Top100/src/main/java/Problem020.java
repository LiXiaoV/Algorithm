/**
 * 旋转图像
 * 
 * @Author: Xiaov
 * @Date: 2024/8/26 04:43
 */
public class Problem020 {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return;
        }

        int top = 0, bottom = row - 1;
        int left = 0, right = col - 1;
        while (top < bottom && left < right) {
            for (int i = left; i < right; i++) {
                rotateSingle(matrix, top, i);
            }
            top++;
            right--;
            bottom--;
            left++;
        }
    }

    public void rotateSingle(int[][] matrix, int x, int y) {
        int row = matrix.length;
        int col = matrix[0].length;
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[col - 1 - y][x];
        matrix[col - 1 - y][x] = matrix[row -1 - x][col - 1 - y];
        matrix[row -1 - x][col - 1 - y] = matrix[y][col - 1 - x];
        matrix[y][col - 1 - x] = tmp;
    }

    // 还有一个水平翻转a[0][0] <==> a[0][row-1], 然后对角线旋转，对角线两边元素互换
    // 这个方法也挺有趣

}
