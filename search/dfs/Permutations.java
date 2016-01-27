package search.dfs;

import java.util.List;
import java.util.ArrayList;

public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ((num == null) || (num.length == 0)) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        getPermutation(result, list, visited, num);
        return result;
    }
    public void getPermutation(List<List<Integer>> result, List<Integer> list, int[] visited, int[] num) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < num.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            list.add(num[i]);
            visited[i] = 1;
            getPermutation(result, list, visited, num);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
