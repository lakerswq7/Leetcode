package string;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int i1 = 0;
        int i2 = 0;
        boolean hasDif = false;
        while (i1 < s.length() || i2 < t.length()) {
            if (i1 < s.length() && i2 < t.length() && s.charAt(i1) == t.charAt(i2)) {
                i1++;
                i2++;
            } else if (hasDif) {
                return false;
            } else {
                if (s.length() > t.length()) {
                    i1++;
                } else if (s.length() < t.length()) {
                    i2++;
                } else {
                    i1++;
                    i2++;
                }
                hasDif = true;
            }
        }
        return hasDif;
    }
}
