package math;

public class PowerOfThree {
	/*
	 * 如果不循环或者递归，那就要取对数 或者 用最大的三的幂来对它取余
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
