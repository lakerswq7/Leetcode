package math;

public class NumberOfDigitOne {
	/*
	 * 思路就是循环算每一位上1的个数，比如abcdef
	 * 算 c 这位上的个数就是
	 * if (c == 0) ab * 1000
	 * if (c == 1) ab * 1000 + 1 + def
	 * if (c > 1)  ab * 1000 + 1000
	 */
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int rear = 0;
        int count = 0;
        int exp = 1;
        while (n > 0) {
            int c = n % 10;
            n = n / 10;
            count += exp * n;
            if (c == 1) {
                count += 1 + rear;
            } else if (c > 1){
                count += exp;
            }
            rear = rear + c * exp;
            exp *= 10;
        }
        return count;
    }
}
