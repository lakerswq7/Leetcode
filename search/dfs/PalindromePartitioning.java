package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> partition = new ArrayList<List<String>>();
        if (s == null) {
            return partition;
        }
        boolean[][] isPalindrom = new boolean[s.length()][s.length()];
        getPartition(partition, isPalindrom, new ArrayList<String>(), s, 0);
        return partition;
    }
    public void getPartition(List<List<String>> partition, boolean[][] isPalindrom, List<String> list, String s, int index) {
        if (index == s.length()) {
            partition.add(new ArrayList<String>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (((i - index <= 2) || isPalindrom[index + 1][i - 1]) && (s.charAt(i) == s.charAt(index))) {
                isPalindrom[index][i] = true;
                list.add(s.substring(index, i + 1));
                getPartition(partition, isPalindrom, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
