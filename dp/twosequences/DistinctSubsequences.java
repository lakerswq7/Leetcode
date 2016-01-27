package dp.twosequences;
/*
 * 0. �������� ��ͬ�Ӵ�ȡ���Ĵ����� 2 sequences -> dp
 * 1. f[i][j] -> S����j���ַ���T����i���ַ���ʱ���ȡ������
 * 2. f[i][j] = f[i - 1][j - 1] + f[i][j - 1] ���S��j���ַ���T��i���ַ����
 *    f[i][j] = f[i][j - 1] ��������
 * 3. f[0][j] = 1 ������һ�ж�Ϊ1��ɨ���ʱ��ֻ��Ҫɨ�ϰ벿�־Ϳ�����
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
