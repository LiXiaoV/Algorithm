import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @Author: Xiaov
 * @Date: 2024/8/26 03:44
 */
public class Problem019 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        if (col == 0) {
            return res;
        }

        int rowH = 0, rowB = row - 1;
        int colL = 0, colR = col - 1;
        while (rowH <= rowB && colL <= colR) {
            for (int i = colL; i <= colR; i++) {
                res.add(matrix[rowH][i]);
            }
            rowH++;
            if (rowH <= rowB && colR >= colL) {
                for (int j = rowH; j <= rowB; j++) {
                    res.add(matrix[j][colR]);
                }
                colR--;
            }
            if (rowH <= rowB && colR >= colL) {
                for (int i = colR; i >= colL; i--) {
                    res.add(matrix[rowB][i]);
                }
                rowB--;
            }
            if (rowH <= rowB && colR >= colL){
                for (int j = rowB; j >= rowH; j--) {
                    res.add(matrix[j][colL]);
                }
                colL++;
            }
        }
        return res;
    }
}
