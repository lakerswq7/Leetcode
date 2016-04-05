package math;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] count = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[count[j]]);
            }
            for (int j = 0; j < count.length; j++) {
                if (ugly[i] == primes[j] * ugly[count[j]]) {
                    count[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}
