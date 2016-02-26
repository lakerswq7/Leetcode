package tree.binarytree;


public class VerifyPreorderSerializationOfABinaryTree {
	public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] pre = preorder.split(",");
        int slot = 1;
        for (String p : pre) {
            if (--slot < 0) {
                return false;
            }
            if (!p.equals("#")) {
                slot += 2;
            }
        }
        return slot == 0;
    }
// 	  自己写的，用stack
//    public boolean isValidSerialization(String preorder) {
//        if (preorder == null || preorder.length() == 0) {
//            return false;
//        }
//        ArrayList<String> pre = getPre(preorder);
//        ArrayList<String> stack = new ArrayList<String>();
//        for (int i = 0; i < pre.size(); i++) {
//            String c = pre.get(i);
//            if (!c.equals("#")) {
//                stack.add(c);
//            } else {
//                while(stack.size() >= 2 && stack.get(stack.size() - 1).equals("#") && !stack.get(stack.size() - 2).equals("#")) {
//                    stack.remove(stack.size() - 1);
//                    stack.remove(stack.size() - 1);
//                }
//                stack.add("#");
//            }
//        }
//        if (stack.size() == 1 && stack.get(0).equals("#")) {
//            return true;
//        }
//        return false;
//    }
//    private ArrayList<String> getPre(String preorder) {
//        ArrayList<String> pre = new ArrayList<String>();
//        int start = 0;
//        for (int i = 0; i < preorder.length(); i++) {
//            if (preorder.charAt(i) == ',') {
//                start = i + 1;
//            } else if (i == preorder.length() - 1 || preorder.charAt(i + 1) == ',') {
//                pre.add(preorder.substring(start, i + 1));
//            }
//        }
//        return pre;
//    }
}
