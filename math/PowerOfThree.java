package math;

public class PowerOfThree {
	/*
	 * �����ѭ�����ߵݹ飬�Ǿ�Ҫȡ���� ���� ������������������ȡ��
	 */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if ((Math.log10(n) / Math.log10(3)) % 1 == 0) {
            return true;
        }
        return false;
    }
}
