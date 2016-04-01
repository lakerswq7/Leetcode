package array;

public class RangeSumQueryImmutable {
	public class NumArray {
	    long[] sum;
	    public NumArray(int[] nums) {
	        sum = new long[nums.length + 1];
	        sum[0] = 0;
	        for (int i = 0; i < nums.length; i++) {
	            sum[i + 1] = sum[i] + nums[i];
	        }
	    }

	    public int sumRange(int i, int j) {
	        return (int)sum[j + 1] - (int)sum[i];
	    }
	}
}
