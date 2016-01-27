package dp.sequence;

/*
 * 0. 不能排序， 求最小的切的次数，sequence -> dp
 * 1. f[i] -> 有i个字符时最小切的次数
 * 2. f[i] = min(f[j]) + 1, 0 <= j < i, 且从j + 1到 i 个子字符串是 palindrome， 考虑最后一个是否有效地思路
 * 3. f[0] = -1
 * 4. f[n]
 * 
 * 其中在算一个子串是不是palindrome的时候，这个时候也要用到dp的思想，可与上面的dp合并到一起
 * 这样总复杂度就是O(n^2)而不是O(n^3)
 * 1. d[i][j] -> 从第i位置的字符到第j位置的字符是否是palindrome
 * 2. d[i][j] = true，如果s[i] == s[j]且d[i + 1][j - 1]也是true
 * d[i][j] = false，如果s[i] != s[j]或者d[i + 1][j - 1]是false
 * 3. d[i][j] = true, 如果i == j 或者(j - i <=2, 且s[i] == s[j])
 * 4. 每一个d[i][j]我们都需要， 可一边赋值isPalindrome一边求解cut, 也可先赋值isPalindrome再求解cut
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }
        int n = s.length();
        int[] cut = new int[n + 1];
        boolean[][] isPalindrome = new boolean[n][n];
        cut[0] = -1;
        for (int i = 1; i < cut.length; i++) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                isPalindrome[j][i - 1] = false;
                if ((s.charAt(j) == s.charAt(i - 1)) && (((i - j) <= 2) || isPalindrome[j + 1][i - 2])) {
                    isPalindrome[j][i - 1] = true;
                    cut[i] = Math.min(cut[j] + 1, cut[i]);
                }
            }
        }
        return cut[n];
    }
}
