package dp.sequence;

import java.util.Set;

/*
 * 0. �����������ܲ��ܻ��ֳɴʵ��еĴʣ�sequence -> dp
 * 1. f[i] -> ǰi���ַ��ܲ��ܱ�����
 * 2. f[i] = true, ���f[j] = true ��j + 1 �� iҲ���ڴʵ䣬���� 0 <= j < i
 * 3. f[0] = true
 * 4. f[n]
 * 
 * һ���Ż���˼·�ǣ����ȼ���dictionary�е��ʵ���ĳ����Ƕ��٣�������ɨ���ʱ��� j ������С��Χ��
 * һ������ i - maxLength���� for(int j = i - 1; (j >= 0) && (j >= i - maxLength); j--)
 * ���������ӶȾͳ���nk������k��dict����ĵ��ʵĳ��ȣ� �������n^2
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if ((s == null) || (s.length() == 0)) {
            return false;
        }
        boolean[] words = new boolean[s.length() + 1];
        words[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if ((words[j] == true) && dict.contains(s.substring(j, i))) {
                    words[i] = true;
                    break;
                }
            }
        }
        return words[s.length()];
    }
}
