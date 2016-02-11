package dp.twosequences;

public class RegularExpressionMatching {
	// 递归解法，好时O(n), 坏时O(n!)
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }
        if (p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p);
        } else {
            return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
    }
	// 不直观的递归
//    public boolean isMatch(String s, String p) {
//        if (s == null || p == null) {
//            return false;
//        }
//        if (p.length() == 0) {
//            return s.length() == 0;
//        }
//        int si = 0, pi = 0;
//        int m = s.length();
//        int n = p.length();
//        while (si < m) {
//            if (pi == n) {
//                return false;
//            }
//            if (pi + 1 < n && p.charAt(pi + 1) == '*') {
//                while (si < m && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.')) {
//                    if (isMatch(s.substring(si), p.substring(pi + 2))) {
//                        return true;
//                    }
//                    si++;
//                }
//                return isMatch(s.substring(si), p.substring(pi + 2));
//            } else if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') {
//                si++;
//                pi++;                
//            } else {
//                return false;
//            }
//        }
//        while (pi + 1 < n && p.charAt(pi + 1) == '*') {
//            pi += 2;
//        }
//        return pi == n;
//    }
	// dp 解法，时间空间均为 O(n ^ 2)
//    public boolean isMatch(String s, String p) {
//        if (s == null || p == null) {
//            return false;
//        }
//        int m = s.length();
//        int n = p.length();
//        
//        boolean[][] match = new boolean[m + 1][n + 1];
//        match[0][0] = true;
//        for (int j = 1; j <= n; j++) {
//            if (p.charAt(j - 1) == '*' && match[0][j - 2]) {
//                match[0][j] = true;
//            } 
//        }
//        
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (match[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
//                    match[i][j] = true;
//                } else if (p.charAt(j - 1) == '*') {
//                    if (match[i][j - 2]) {
//                        match[i][j] = true;
//                    }
//                    if (match[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
//                        match[i][j] = true;
//                    }
//                }
//            }
//        }
//        return match[m][n];
//    }
//    public static void main(String[] args) {
//    	RegularExpressionMatching sol = new RegularExpressionMatching();
//    	System.out.println(sol.isMatch("aab", "a.*"));
//    }
}
