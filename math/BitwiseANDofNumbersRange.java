package math;

public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int result = m & n;
        int mask = 1 << 30;
        for (int i = 0; i < 31; i++) {
            if ((result & mask) == 0 && (m & mask) != (n & mask)) {
                result &= ~((mask << 1) - 1);
                break;
            }
            mask >>= 1;
        }
        return result;
    }
}
