package math;

public class ReverseBits {
	/*
	 * ������Ż���˼����ǣ� ��hashmap����ǰ�����
	 * ���԰����ַ�Ϊ4��byte���ֱ���ֱ��
	 */
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev = rev << 1;
            rev += n & 1;
            n = n >> 1;
        }
        return rev;
    }
//    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//    public int reverseBits(int n) {
//        int rev = 0;
//        for (int i = 0; i < 4; i++) {
//            rev += reverse((n >> (8 * i)) & 0xFF) << 8 * (3 - i);
//        }
//        return rev;
//    }
//    private int reverse(int x) {
//        if (map.containsKey(x)) {
//            return map.get(x);
//        }
//        int r = 0;
//        for (int i = 0; i < 8; i++) {
//            r = r << 1;
//            r += (x >> i) & 1;
//        }
//        map.put(x, r);
//        return r;
//    }
}
