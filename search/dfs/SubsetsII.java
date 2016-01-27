package search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ((num == null) || (num.length == 0)) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        getSubsets(result, list, num, 0);
        return result;
    }
    public void getSubsets(List<List<Integer>> result, List<Integer> list, int[] num, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < num.length; i++) {
            if ((i != pos) && (num[i] == num[i - 1])) {
                continue;
            }
            list.add(num[i]);
            getSubsets(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
