/**
 * 除自身以外数组的乘积
 * 
 * @Author: Xiaov
 * @Date: 2024/8/25 23:24
 */
public class Problem016 {
    public int[] productExceptSelf(int[] nums) {
        int numSize = nums.length;
        int[] productArr = new int[numSize];
        int[] res = new int[numSize];
        productArr[0] = nums[0];
        for (int i = 1; i < numSize - 1; i++) {
            productArr[i] = productArr[i -1] * nums[i];
        }

        res[numSize - 1] = productArr[numSize - 2];
        productArr[numSize - 1] = nums[numSize - 1];
        for (int i = numSize - 2; i > 0; i--) {
            res[i] = productArr[i + 1] * productArr[i - 1];
            productArr[i] = productArr[i + 1] * nums[i];
        }
        res[0] = productArr[1];
        return res;
    }

    public int[] productExceptSelfFunc2(int[] nums) {
        int numSize = nums.length;
        int[] res = new int[numSize];
        res[0] = nums[0];
        for (int i = 1; i < numSize - 1; i++) {
            res[i] = res[i -1] * nums[i];
        }
        res[numSize - 1] = res[numSize - 2];
        int product = nums[numSize - 1];
        for (int i = numSize - 2; i > 0; i--) {
            res[i] = product * res[i - 1];
            product = product * nums[i];
        }
        res[0] = product;
        return res;
    }
}
