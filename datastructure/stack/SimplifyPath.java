package datastructure.stack;

import java.util.ArrayList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if ((path == null) || (path.length() == 0)) {
            return "";
        }
        ArrayList<String> stack = new ArrayList<String>();
        int start = 0;
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
