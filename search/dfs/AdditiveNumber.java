package search.dfs;

import java.util.ArrayList;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return isAdditive(new ArrayList<Double>(), num, 0);
    }
    private boolean isAdditive(ArrayList<Double> list, String num, int pos) {
        if (pos == num.length() && list.size() >= 3) {
            return true;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                return false;
            }
            double cur = Double.parseDouble(num.substring(pos, i + 1));
            if (outOfRange(cur)) {
                return false;
            }
            if (list.size() >= 2) {
                if (list.get(list.size() - 1) + list.get(list.size() - 2) == cur) {
                    list.add(cur);
                    if (isAdditive(list, num, i + 1)) {
                        return true;
                    }
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(cur);
                if (isAdditive(list, num, i + 1)) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
    private boolean outOfRange(double num) {
        return num > Long.MAX_VALUE || num < Long.MIN_VALUE;
    }
}
