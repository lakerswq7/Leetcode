package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> comb = new ArrayList<List<Integer>>();
        getComb(comb, new ArrayList<Integer>(), n, k, 1);
        return comb;
    }
    public void getComb(List<List<Integer>> comb, List<Integer> list, int n, int k, int pos) {
        if (k == 0) {
            comb.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = pos; i <= n; i++) {
            list.add(i);
            getComb(comb, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
