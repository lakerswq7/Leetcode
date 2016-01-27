package search.dfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ((S == null) || (S.length == 0)) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(S);
        getSubsets(result, list, S, 0);
        return result;
    }
    public void getSubsets(List<List<Integer>> result, List<Integer> list, int[] S, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < S.length; i++) {
            list.add(S[i]);
            getSubsets(result, list, S, pos + 1);
            list.remove(list.size() - 1);
        }
    }
}
