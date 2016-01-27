package dp.twosequences;
/*
 * 0. 不能排序， 求不同子串取法的次数， 2 sequences -> dp
 * 1. f[i][j] -> S串第j个字符，T串第i个字符的时候的取法个数
 * 2. f[i][j] = f[i - 1][j - 1] + f[i][j - 1] 如果S第j个字符和T第i个字符相等
 *    f[i][j] = f[i][j - 1] 如果不相等
 * 3. f[0][j] = 1 ，即第一行都为1，扫描的时候只需要扫上半部分就可以了
 * 4. f[m][n]
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if ((S == null) || (T == null)) {
            return 0;
        }
        int[][] distinct = new int[T.length() + 1][S.length() + 1];
        for (int i = 0; i <= S.length(); i++) {
            distinct[0][i] = 1;
        }
        for (int i = 1; i <= T.length(); i++) {
            for (int j = i; j <= S.length(); j++) {
                if (S.charAt(j - 1) == T.charAt(i - 1)) {
                    distinct[i][j] = distinct[i][j - 1] + distinct[i - 1][j - 1];
                } else {
                    distinct[i][j] = distinct[i][j - 1];
                }
            }
        }
        return distinct[T.length()][S.length()];
    }
}
