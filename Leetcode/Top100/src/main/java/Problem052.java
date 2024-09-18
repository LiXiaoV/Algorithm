import java.util.Deque;
import java.util.LinkedList;

/**
 * 腐烂的橘子
 *
 * @Author: Xiaov
 * @Date: 2024/9/19 02:45
 */
public class Problem052 {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        Deque<Integer> rotQueue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == 0) continue;
                else if (grid[i][j] == 1) {
                    count++;
                }
                else if (grid[i][j] == 2) {
                    rotQueue.offer(i * nc + j);
                }
            }
        }
        if (count == 0) return 0;
        int minutes = 0;
        while (!rotQueue.isEmpty()) {
            int size = rotQueue.size();
            for (int i = 0; i < size; i++) {
                Integer rotNum = rotQueue.poll();
                int rotR = rotNum / nc;
                int rotC = rotNum % nc;
                if (rotR - 1 >= 0 && grid[rotR - 1][rotC] == 1) {
                    grid[rotR - 1][rotC] = 2;
                    count -= 1;
                    rotQueue.offer((rotR - 1) * nc + rotC);
                }
                if (rotC - 1 >= 0 && grid[rotR][rotC - 1] == 1) {
                    grid[rotR][rotC - 1] = 2;
                    count-=1;
                    rotQueue.offer(rotR * nc + rotC - 1);
                }
                if (rotR + 1 < nr && grid[rotR + 1][rotC] == 1) {
                    grid[rotR + 1][rotC] = 2;
                    count -= 1;
                    rotQueue.offer((rotR + 1) * nc + rotC);
                }
                if (rotC + 1 < nc && grid[rotR][rotC + 1] == 1) {
                    grid[rotR][rotC + 1] = 2;
                    count -= 1;
                    rotQueue.offer(rotR * nc + rotC + 1);
                }
            }
            minutes++;
        }
        if (count == 0) return minutes - 1;
        return -1;
    }
}
