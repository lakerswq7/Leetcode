package math;

public class BitwiseANDofNumbersRange {
	/*
	 * ˼������ҵ�m �� n �Ĺ���ǰ׺������ӵ�һ����һ����λ��ʼ����0
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
