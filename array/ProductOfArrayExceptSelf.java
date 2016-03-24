package array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        product[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            product[i] = product[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            product[i] = product[i] * right;
        }
        return product;
    }
}
