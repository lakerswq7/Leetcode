package search.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return new ArrayList<Integer>();
        }
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        return helper(input, map);
    }
    private ArrayList<Integer> helper(String input, HashMap<String, ArrayList<Integer>> map) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        ArrayList<Integer> rst = new ArrayList<Integer>();
        boolean isNumber = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ("+-*".contains(String.valueOf(c))) {
                isNumber = false;
                String prefix = input.substring(0, i);
                String suffix = input.substring(i + 1);
                for (int n1 : helper(prefix, map)) {
                    for (int n2 : helper(suffix, map)) {
                        int r = 0;
                        switch (c) {
                            case '+' : r = n1 + n2; break;
                            case '-' : r = n1 - n2; break;
                            case '*' : r = n1 * n2; break;
                        }
                        rst.add(r);
                    }
                }
            }
        }
        if (isNumber) {
            rst.add(Integer.parseInt(input));
        }
        map.put(input, rst);
        return rst;
    }
}
