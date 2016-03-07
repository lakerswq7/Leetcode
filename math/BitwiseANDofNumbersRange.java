package math;

public class BitwiseANDofNumbersRange {
	/*
	 * 思想就是找到m 和 n 的公共前缀，后面从第一个不一样的位开始都是0
	 */
    public int rangeBitwiseAnd(int m, int n) {
        for (int i = 30; i >= 0; i--) {
            int mask = 1 << i;
            if ((m & mask) != (n & mask)) {
                return m & ~((mask << 1) - 1);
            }
        }
        return m;
    }
}
