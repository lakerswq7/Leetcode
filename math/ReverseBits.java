package math;

public class ReverseBits {
    public int reverseBits(int n) {
        int k = 0;
        int mask = 0;
        for (int i = 0; i < 32; i++) {
            k = n & 0x1;
            n = n >> 1;
            mask = mask << 1;
            mask |= k;
        }
        return mask;
    }
}
