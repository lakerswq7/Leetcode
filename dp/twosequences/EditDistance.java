package dp.twosequences;

/*
 * 0. ���������������ַ���֮��ת������С������ 2 sequences -> dp
 * 1. f[i][j] -> word1 ��i���ַ���word2 ��j���ַ���ʱ�����С����
 * 2. f[i][j] = f[i - 1][j - 1] �����i���ַ��͵�j���ַ����
 * 	  f[i][j] = min(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1]) + 1,��������
 * 3. f[i][0] = i, f[0][i] = i �������е�i�����Ȱѵ�һ�к͵�һ�и�ֵ
 * 4. f[m][n]
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            distance[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            distance[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(distance[i - 1][j - 1], Math.min(distance[i - 1][j], distance[i][j - 1])) + 1;
                }
            }
        }
        return distance[word1.length()][word2.length()];
    }
}
