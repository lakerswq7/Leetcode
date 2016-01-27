package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        getPath(root, sum, list, result);
        return result;
    }
    public void getPath(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if ((root.left == null) && (root.right == null)) {
            if (root.val == sum) {
                list.add(root.val);
                result.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
            }
        } else {
            list.add(root.val);
            getPath(root.left, sum - root.val, list, result);
            getPath(root.right, sum - root.val, list, result);
            list.remove(list.size() - 1);
        }
    }
}
