package search.dfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        if (num == null) {
            return combinations;
        }
        Arrays.sort(num);
        getSum(combinations, new ArrayList<Integer>(), num, target, 0);
        return combinations;
    }
    public void getSum(List<List<Integer>> combinations, List<Integer> list, int[] num, int target,int pos) {
        if (target == 0) {
            combinations.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = pos; i < num.length; i++) {
            if ((i > pos) && (num[i] == num[i - 1])) {
                continue;
            }
            list.add(num[i]);
            getSum(combinations, list, num, target - num[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
