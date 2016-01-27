package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = generateTreesHelp(1, n);
        return result;
    }
    public ArrayList<TreeNode> generateTreesHelp(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> lefts = generateTreesHelp(start, i - 1);
            ArrayList<TreeNode> rights = generateTreesHelp(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right: rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
