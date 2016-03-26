package tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        if (root == null) {
            return rst;
        }
        helper(root, rst, new ArrayList<Integer>());
        return rst;
    }
    private void helper(TreeNode root, List<String> rst, ArrayList<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            rst.add(buildPath(path));
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null) {
            helper(root.left, rst, path);
        }
        if (root.right != null) {
            helper(root.right, rst, path);
        }
        path.remove(path.size() - 1);
    }
    private String buildPath(ArrayList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
