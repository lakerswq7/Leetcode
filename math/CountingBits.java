package math;

public class CountingBits {
    public int[] countBits(int num) {
        int[] rst = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            rst[i] = rst[i >> 1] + (i & 1);
        }
        return rst;
    }
}
