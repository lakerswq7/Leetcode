package tree.binarytree;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        Money m = robHouse(root);
        return Math.max(m.rob, m.noRob);
    }
    private Money robHouse(TreeNode root) {
        Money m = new Money();
        if (root == null) {
            m.rob = 0;
            m.noRob = 0;
        } else {
            Money left = robHouse(root.left);
            Money right = robHouse(root.right);
            m.rob = root.val + left.noRob + right.noRob;
            m.noRob = Math.max(left.rob, left.noRob) + Math.max(right.rob, right.noRob);
        }
        return m;
    }
    class Money {
        int rob;
        int noRob;
    }
}
