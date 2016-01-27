package string;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int sp = 0;
        int tp = 0;
        boolean isDif = false;
        while (sp < s.length() || tp < t.length()) {
            if (sp < s.length() && tp < t.length() && s.charAt(sp) == t.charAt(tp)) {
                sp++;
                tp++;
            } else {
                if (isDif) {
                    return false;
                }
                if (s.length() > t.length()) {
                    sp++;
                } else if (s.length() < t.length()) {
                    tp++;
                } else {
                    sp++;
                    tp++;
                }
                isDif = true;
            }
        }
        if (isDif) {
            return true;
        } else {
            return false;
        }
    }
}
