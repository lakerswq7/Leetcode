package tree.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) {
            return rst;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (!map.containsKey(p.pos)) {
                map.put(p.pos, new ArrayList<Integer>());
            }
            map.get(p.pos).add(p.root.val);
            min = Math.min(min, p.pos);
            max = Math.max(max, p.pos);
            if (p.root.left != null) {
                queue.offer(new Pair(p.root.left, p.pos - 1));
            }
            if (p.root.right != null) {
                queue.offer(new Pair(p.root.right, p.pos + 1));
            }
        }
        for (int i = min; i <= max; i++) {
            rst.add(map.get(i));
        }
        return rst;
    }
    class Pair {
        TreeNode root;
        int pos;
        Pair(TreeNode root, int pos) {
            this.root = root;
            this.pos = pos;
        }
    }
}
