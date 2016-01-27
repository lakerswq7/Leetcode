package dp.twosequences;
/*
 * 0. �������� ���Ƿ��ܽ����ɣ� 2 sequences -> dp
 * 1. f[i][j] -> s3��ǰ��i + j���ַ��ܷ���s1��ǰi���ַ���s2��ǰj���ַ�����
 * 2. f[i][j] = true�� ���s3�ĵ�i + j���ַ�����s1�ĵ�i���ַ�����f[i - 1][j] = true
 * 	  �������s3�ĵ�i + j���ַ�����s2�ĵ�j���ַ�����f[i][j - 1] = true
 * 3. f[0][j] = f[0][j - 1]���s3�ĵ�j���ַ�����s2�ĵ�j���ַ�
 *    f[i][0] = f[i - 1][0]���s3�ĵ�i���ַ�����s1�ĵ�i���ַ�
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
