package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<String>();
        if ((s == null) || (s.length() < 4) || (s.length() > 12)) {
            return ips;
        }
        helper(s, ips, new ArrayList<String>(), 0);
        return ips;
    }
    public void helper(String s, List<String> ips, List<String> list, int start) {
        if ((list.size() == 4) && (start == s.length())) {
            StringBuilder ip = new StringBuilder();
            for (String n : list) {
                ip.append(".");
                ip.append(n);
            }
            ips.add(ip.substring(1));
            return;
        }
        for (int i = start; i < Math.min(s.length(), start + 3); i++) {
            String digit = s.substring(start, i + 1);
            if (isValid(digit)) {
                list.add(digit);
                helper(s, ips, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isValid(String digit) {
        if (digit.charAt(0) == '0') {
            return digit.equals("0");
        }
        int num = Integer.parseInt(digit);
        return (num >= 0) && (num <= 255);
    }
}
