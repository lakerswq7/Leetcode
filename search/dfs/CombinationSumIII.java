package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> comb = new ArrayList<List<Integer>>();
        findComb(comb, new ArrayList<Integer>(), k, n, 1);
        return comb;
    }
    private void findComb(List<List<Integer>> comb, List<Integer> list, int k, int n, int pos) {
        if (n == 0 && k == 0) {
            comb.add(new ArrayList<Integer>(list));
            return;
        }
        if (k == 0 || n == 0) {
            return;
        }
        for (int i = pos; i <= 9 ; i++) {
            list.add(i);
            findComb(comb, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
