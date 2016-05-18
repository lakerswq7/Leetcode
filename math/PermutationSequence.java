package math;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (n < 1) {
            return "";
        }
        int base = 1;
        for (int i = 1; i <= n; i++) {
            base *= i;
        }
        if (k > base) {
            return "";
        }
        k = k - 1;
        boolean[] visited = new boolean[n];
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            base /= i;
            int num = k / base;
            k = k % base;
            for (int j = 0; j < n; j++) {
                if (visited[j] == false) {
                    if (num == 0) {
                        sb.append(j + 1);
                        visited[j] = true;
                        break;
                    }
                    num--;
                }
            }
        }
        return sb.toString();
    }
}
