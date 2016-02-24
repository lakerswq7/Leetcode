package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ip = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return ip;
        }
        restoreIP(ip, new ArrayList<String>(), s, 0);
        return ip;
    }
    private void restoreIP(List<String> ip, ArrayList<String> list, String s, int pos) {
        if (list.size() == 4 && pos == s.length()) {
            addToIP(ip, list);
            return;
        }
        if (list.size() == 4 || pos == s.length()) {
            return;
        }
        for (int i = pos; i < Math.min(pos + 3, s.length()); i++) {
            String digit = s.substring(pos, i + 1);
            if (isValid(digit)) {
                list.add(digit);
                restoreIP(ip, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isValid(String digit) {
        if (digit.charAt(0) == '0') {
            return digit.length() == 1;
        }
        int num = Integer.parseInt(digit);
        return num >= 0 && num <= 255;
    }
    private void addToIP(List<String> ip, ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(list.get(i));
            if (i != 3) {
                sb.append(".");
            }
        }
        ip.add(sb.toString());
    }
}
