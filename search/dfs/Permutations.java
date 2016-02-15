package search.dfs;

import java.util.List;
import java.util.ArrayList;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        boolean[] visited = new boolean[nums.length];
        getPerm(rst, new ArrayList<Integer>(), nums, visited);
        return rst;
    }
    private void getPerm(List<List<Integer>> rst, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            getPerm(rst, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
