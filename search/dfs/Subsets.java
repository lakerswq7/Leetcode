package search.dfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<List<Integer>>();
        if (nums == null) {
            return subset;
        }
        Arrays.sort(nums);
        getSub(subset, new ArrayList<Integer>(), nums, 0);
        return subset;
    }
    private void getSub(List<List<Integer>> subset, List<Integer> list, int[] nums, int pos) {
        subset.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            getSub(subset, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
