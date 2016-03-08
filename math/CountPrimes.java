package math;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i * i < n; i++) {
            if (!notPrime[i]) {
                for (int j = i; j * i < n; j++) {
                    notPrime[j * i] = true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
