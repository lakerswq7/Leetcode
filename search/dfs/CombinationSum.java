package search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (candidates == null) {
            return combinations;
        }
        Arrays.sort(candidates);
        getSum(combinations, new ArrayList<Integer>(), candidates, target, 0);
        return combinations;
    }
    public void getSum(List<List<Integer>> combinations, List<Integer> list, int[] candidates, int target,int pos) {
        if (target == 0) {
            combinations.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if ((i != 0) && (candidates[i] == candidates[i - 1])) {
                continue;
            }
            list.add(candidates[i]);
            getSum(combinations, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
