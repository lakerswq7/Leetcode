package math;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        int mark;
        for (int i = 0; i < 32; i++) {
            mark = n & 0x1;
            n = n >> 1;
            count += mark;
        }
        return count;
    }
}
