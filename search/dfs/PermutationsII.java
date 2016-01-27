package search.dfs;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if ((num == null) || (num.length == 0)) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        Arrays.sort(num);
        getPermutation(result, list, visited, num);
        return result;
    }
    public void getPermutation(List<List<Integer>> result, List<Integer> list, int[] visited, int[] num) {
        if (list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if ((visited[i] == 1) || ((i != 0) && (visited[i - 1] == 0) && (num[i] == num[i - 1]))) {
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
