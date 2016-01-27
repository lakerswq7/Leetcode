package dp.sequence;

import java.util.Set;

/*
 * 0. 不能排序，求能不能划分成词典中的词，sequence -> dp
 * 1. f[i] -> 前i个字符能不能被划分
 * 2. f[i] = true, 如果f[j] = true 且j + 1 到 i也属于词典，这里 0 <= j < i
 * 3. f[0] = true
 * 4. f[n]
 * 
 * 一种优化的思路是，首先计算dictionary中单词的最长的长度是多少，这样在扫描的时候的 j 可以缩小范围到
 * 一定大于 i - maxLength，即 for(int j = i - 1; (j >= 0) && (j >= i - maxLength); j--)
 * 这样，复杂度就成了nk，其中k是dict中最长的单词的长度， 否则就是n^2
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
