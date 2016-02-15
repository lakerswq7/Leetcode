package highfrequency;

public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        
        int k = n / 2;
        int l = n - k * 2;
        double p1 = myPow(x, k);
        double p2 = myPow(x, l);
        
        return p1 * p1 * p2;
    }
}
