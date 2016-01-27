package tree.binarysearchtree;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k < i; k++) {
                num[i] += num[k] * num[i - k - 1];
            }
        }
        return num[n];
    }
    public static void main(String args[]) {
    	int n = 5;
    	UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
    	System.out.println(solution.numTrees(n));
    }
}
