package highfrequency;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] rst = new int[2];
        int temp = 0;
        for (int n : nums) {
            temp ^= n;
        }
        int mask = 1;
        while ((mask & temp) == 0) {
            mask = mask << 1;
        }
        for (int n : nums) {
            if ((n & mask) == 0) {
                rst[0] ^= n;
            } else {
                rst[1] ^= n;
            }
        }
        return rst;
    }
}
