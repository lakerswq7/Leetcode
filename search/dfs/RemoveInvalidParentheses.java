package search.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveInvalidParentheses {
/*
 * dfs 解法
 */
    public List<String> removeInvalidParentheses(String s) {
        ArrayList<String> rst = new ArrayList<String>();
        dfs(rst, s, 0, 0, new char[]{'(', ')'});
        return rst;
    }
    private void dfs(ArrayList<String> rst, String s, int lastRe, int next, char[] par) {
        int count = 0;
        for (int i = next; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                count++;
            } else if (s.charAt(i) == par[1]) {
                if (count > 0) {
                    count--;
                } else {
                	/*
                	 * 只删除连续'('中的第一个，并且保存删除的位置，下次再删除的时候从这个之后算
                	 * 目的是防止重复
                	 */
                    for (int j = lastRe; j <= i; j++) {
                        if (s.charAt(j) == par[1] && (j == 0 || s.charAt(j - 1) != par[1])) {
                            dfs(rst, s.substring(0, j) + s.substring(j + 1), j, i, par);
                        }
                    }
                    /*
                     * 如果没问题，那就进入是否反转的考察，在继续留在这一层
                     * 如果有问题，这次迭代就结束了，需要下一层解决
                     */
                    return;
                }
            }
        }
        s = new StringBuilder(s).reverse().toString();
        /*
         * 如果已经反转过了就表明正反都查完了，直接返回
         * 如果没有，需要反转一下，从另一边开始查
         */
        if (par[0] == '(') {
            dfs(rst, s, 0, 0, new char[]{')', '('});
        } else {
            rst.add(s);
        }
    }
    /*
     * bfs解法
     */
    public List<String> removeInvalidParentheses2(String s) {
        ArrayList<String> rst = new ArrayList<String>();
        if (s == null) {
            return rst;
        }
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;
        
        while (!queue.isEmpty()) {
            if (found) {
                return rst;
            }
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                s = queue.poll();
                if (isValid(s)) {
                    rst.add(s);
                    found = true;
                } else {
                	/*
                	 * 把每个可能的地方做替换，看看是否访问过
                	 */
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                            String t = s.substring(0, i) + s.substring(i + 1);
                            if (!visited.contains(t)) {
                                visited.add(t);
                                queue.offer(t);
                            }
                        }
                    }
                }
            }
        }
        return rst;
        
    }
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}
