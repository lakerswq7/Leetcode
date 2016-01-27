package dp.sequence;

/*
 * 0. �������� ����С���еĴ�����sequence -> dp
 * 1. f[i] -> ��i���ַ�ʱ��С�еĴ���
 * 2. f[i] = min(f[j]) + 1, 0 <= j < i, �Ҵ�j + 1�� i �����ַ����� palindrome�� �������һ���Ƿ���Ч��˼·
 * 3. f[0] = -1
 * 4. f[n]
 * 
 * ��������һ���Ӵ��ǲ���palindrome��ʱ�����ʱ��ҲҪ�õ�dp��˼�룬���������dp�ϲ���һ��
 * �����ܸ��ӶȾ���O(n^2)������O(n^3)
 * 1. d[i][j] -> �ӵ�iλ�õ��ַ�����jλ�õ��ַ��Ƿ���palindrome
 * 2. d[i][j] = true�����s[i] == s[j]��d[i + 1][j - 1]Ҳ��true
 * d[i][j] = false�����s[i] != s[j]����d[i + 1][j - 1]��false
 * 3. d[i][j] = true, ���i == j ����(j - i <=2, ��s[i] == s[j])
 * 4. ÿһ��d[i][j]���Ƕ���Ҫ�� ��һ�߸�ֵisPalindromeһ�����cut, Ҳ���ȸ�ֵisPalindrome�����cut
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
