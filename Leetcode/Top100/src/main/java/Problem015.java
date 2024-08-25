/**
 * 轮转数组
 *
 * @Author: Xiaov
 * @Date: 2024/8/25 21:43
 */
public class Problem015 {

    public void rotate(int[] nums, int k) {
        int numSize = nums.length;
        k = k % numSize;
        int[] newArr = new int[numSize];
        for (int i = 0; i < numSize; i++) {
            newArr[(i + k) % numSize] = nums[i];
        }
        System.arraycopy(newArr, 0 , nums, 0, numSize);
    }

    public void rotateFunc2(int[] nums, int k) {
        int numSize = nums.length;
        k = k % numSize;
        int forNum = gcd(numSize, k);
        for (int i = 0; i < forNum; i++) {
            int start = i;
            int num = nums[start];
            do {
                start = (start + k) % numSize;
                int tmp = nums[start];
                nums[start] = num;
                num = tmp;
            }while (start != i);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public void rotateFunc3(int[] nums, int k) {
        int numSize = nums.length;
        k = k % numSize;
        reverse(nums, 0 , numSize - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, numSize - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

}
