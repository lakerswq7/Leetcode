package dp.twosequences;

public class ScrambleString {
	// dp 算法， O(n ^ 4)
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2) || s1.length() == 0) {
            return true;
        }
        int n = s1.length();
        boolean[][][] f = new boolean[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    f[i][j][0] = true;
                }
            }
        }
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                for (int j = 0; j < n - k; j++) {
                    for (int m = 0; m < k; m++) {
                        if ((f[i][j][m] && f[i + m + 1][j + m + 1][k - m - 1]) || (f[i][j + k - m][m] && f[i + m + 1][j][k - m - 1])) {
                            f[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[0][0][n - 1];
    }
    
//	简单明了递归算法，O(4 ^ n)
//    public boolean isScramble(String s1, String s2) {
//        if (s1 == null || s2 == null || s1.length() != s2.length()) {
//            return false;
//        }
//        if (s1.length() == 0 || s1.equals(s2)) {
//            return true;
//        }
//        if (!isAnagram(s1, s2)) {
//            return false;
//        }
//        for (int i = 0; i < s1.length() - 1; i++) {
//            String s11 = s1.substring(0, i + 1);
//            String s12 = s1.substring(i + 1, s1.length());
//            String s21 = s2.substring(0, i + 1);
//            String s22 = s2.substring(i + 1, s2.length());
//            String s31 = s2.substring(s2.length() - i - 1, s2.length());
//            String s32 = s2.substring(0, s2.length() - i - 1);
//            if ((isScramble(s11, s21) && isScramble(s12, s22)) || (isScramble(s11, s31) && isScramble(s12, s32))) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean isAnagram(String s1, String s2) {
//        int[] count = new int[26];
//        for (int i = 0; i < s1.length(); i++) {
//            count[s1.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < s2.length(); i++) {
//            count[s2.charAt(i) - 'a']--;
//        }
//        for (int i : count) {
//            if (i != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
