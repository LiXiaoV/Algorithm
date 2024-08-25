/**
 * 矩阵置零
 *
 * @Author: Xiaov
 * @Date: 2024/8/26 01:45
 */
public class Problem018 {

    // 这题出得跟屎一样，tmd缺那点空间？fuck you！！！
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 第一行
        boolean flagRow0 = false;

        // 第一列
        boolean flagCol0 = false;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
                break;
            }
        }

        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                flagRow0 = true;
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (flagRow0) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }

        if (flagCol0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

    }


}
