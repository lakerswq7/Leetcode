package math;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int scope = 1;
        for (int i = 1; i < n; i++) {
            scope *= i;
        }
        k = k - 1;
        StringBuilder sequence = new StringBuilder();
        boolean[] used = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            int index = k / scope;
            k = k % scope;
            for (int j = 0; j < n; j++) {
                if (used[j] == false) {
                    if (index == 0) {
                        sequence.append(j + 1);
                        used[j] = true;
                        break;
                    } else {
                        index--;
                    }
                }
            }
            
            if (i != 0) {
                scope /= i;
            }
        }
        return sequence.toString();
    }
}
