package dp.twosequences;

public class WildcardMatching {
	// 优化的递归思路非递归解法，复杂度，好的时候O(n), 坏的时候O(n ^ 2). 核心思想是，如果 * 后面出现了 * 那么就只用从后面的序列
	// 去找可能的解法，如果后面都不能解得话，那也没必要往前面的 * 回溯了。
    public boolean isMatch(String s, String p) {
        if ((s == null) || (p == null)) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        int si, pi, sp, pp;
        si = pi = sp = pp = 0;

        boolean hasStar = false;
        while (si < m) {
            if ((pi < n) && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
                si++;
                pi++;
            } else if (pi < n && p.charAt(pi) == '*') {
                pi++;
                if (pi == n) {
                    return true;
                }
                hasStar = true;
                pp = pi;
                sp = si;
            } else {
                if (hasStar) {
                    pi = pp;
                    sp++;
                    si = sp;
                } else {
                    return false;
                }
            }
        }
        while (pi < n && p.charAt(pi) == '*') {
            pi++;
        } 
        return pi == n;
    }	
	// dp 算法，时间空间都是O(n ^ 2)
//    public boolean isMatch(String s, String p) {
//        if (s == null || p == null) {
//            return false;
//        }
//        int m = s.length();
//        int n = p.length();
//        boolean[][] match = new boolean[m + 1][n + 1];
//        
//        match[0][0] = true;
//        for (int j = 1; j <= n; j++) {
//        	match[0][j] = (p.charAt(j - 1) == '*') && match[0][j - 1];
//        }
//        
//        for (int j = 1; j <= n; j++) {
//            for (int i = 1; i <= m; i++) {
//                if (match[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) {
//                        match[i][j] = true;
//                } else if (p.charAt(j - 1) == '*') {
//                    match[i][j] = match[i][j - 1] || match[i - 1][j];
//                }
//            }
//        }
//        return match[m][n];
//    }
    public static void main(String[] args) {
    	WildcardMatching sol = new WildcardMatching();
    	System.out.println(sol.isMatch("aaab", "?*a"));
    }
}
