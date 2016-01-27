package dp.twosequences;
/*
 * 0. 不能排序， 求是否能交错构成， 2 sequences -> dp
 * 1. f[i][j] -> s3的前第i + j个字符能否由s1的前i个字符和s2的前j个字符构成
 * 2. f[i][j] = true， 如果s3的第i + j个字符等于s1的第i个字符，且f[i - 1][j] = true
 * 	  或者如果s3的第i + j个字符等于s2的第j个字符，且f[i][j - 1] = true
 * 3. f[0][j] = f[0][j - 1]如果s3的第j个字符等于s2的第j个字符
 *    f[i][0] = f[i - 1][0]如果s3的第i个字符等于s1的第i个字符
 * 4. f[m][n]
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1 == null) || (s2 == null) || (s3 == null) || (s3.length() != s1.length() + s2.length())) {
            return false;
        }
        boolean[][] interleaving = new boolean[s1.length() + 1][s2.length() + 1];
        interleaving[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
                interleaving[i][0] = interleaving[i - 1][0];
            }
        }
        for (int i = 1; i <= s2.length(); i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
                interleaving[0][i] = interleaving[0][i - 1];
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                interleaving[i][j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1)) && interleaving[i - 1][j])
                		|| ((s2.charAt(j - 1) == s3.charAt(i + j - 1)) && interleaving[i][j - 1]);
            }
        }
        return interleaving[s1.length()][s2.length()];
    }
}
