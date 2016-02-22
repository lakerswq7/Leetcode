package datastructure.stack;

import java.util.ArrayList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if ((path == null) || (path.length() == 0)) {
            return "";
        }
        ArrayList<String> stack = new ArrayList<String>();
        int start = 0;
        /*
         * 字符串分割的问题，这里的思路是，如果碰到分隔符，就起始位加一，如果不是分隔符
         * 而下一位是分隔符，就用之前的起始位执行分割. 这样能有效忽略中间连续的分隔符
         */
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                start = i + 1;
            } else if ((i == path.length() - 1) || (path.charAt(i + 1) == '/')) {
                String dir = path.substring(start, i + 1);
                if (dir.equals(".")) {
                    continue;
                } else if (dir.equals("..")) {
                    if (stack.size() != 0) {
                        stack.remove(stack.size() - 1);
                    }
                } else {
                    stack.add(dir);
                }
            }
        }
        StringBuilder p = new StringBuilder();
        for (String directory : stack) {
            p.append('/');
            p.append(directory);
        }
        if (p.length() == 0) {
            p.append('/');
        }
        return p.toString();
    }
}
