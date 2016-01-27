package string;

public class LongestPalindromicSubstring {
	// O(n) 的解法
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String p = preProcessing(s);
        int[] length = new int[p.length()];
        int maxC = 0;
        int maxLength = 0;
        int c = 0;
        int boundry = 0;
        for (int i = 1; i < p.length() - 1; i++) {
            length[i] = i < boundry ? Math.min(length[2 * c - i], boundry - i) : 0;
            while (p.charAt(i - length[i] - 1) == p.charAt(i + length[i] + 1)) {
                length[i]++;
            }
            if (i + length[i] > boundry) {
                boundry = i + length[i];
                c = i;
            }
            if (length[i] > maxLength) {
                maxLength = length[i];
                maxC = c;
            }
        }
        StringBuilder rst = new StringBuilder();
        for (int i = maxC - maxLength; i <= maxC + maxLength; i++) {
            if (p.charAt(i) != '#') {
                rst.append(p.charAt(i));
            }
        }
        return rst.toString();
    }
    public String preProcessing(String s) {
        StringBuilder process = new StringBuilder();
        process.append('^');
        for (int i = 0; i < s.length(); i++) {
            process.append('#');
            process.append(s.charAt(i));
        }
        process.append('#');
        process.append('$');
        return process.toString();
    }
// 扫两边的解法，O(n ^ 2)
//    public String longestPalindrome(String s) {
//        if ((s == null) || (s.length() == 0)) {
//            return s;
//        }
//        String palindrome = "";
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int count = 0;
//            for (int j = 0; ; j++) {
//                if ((i - j >= 0) && (i + j < s.length()) && (s.charAt(i - j) == s.charAt(i + j))) {
//                    count += 2;
//                } else {
//                    count--;
//                    if (count > max) {
//                        max = count;
//                        palindrome = s.substring(i - j + 1, i + j);
//                    }
//                    break;
//                }
//            }
//            count = 0;
//            for (int j = 0; ; j++) {
//                if ((i - j >= 0) && (i + j + 1 < s.length()) && (s.charAt(i - j) == s.charAt(i + j + 1))) {
//                    count += 2;
//                } else {
//                    if (count > max) {
//                        max = count;
//                        palindrome = s.substring(i - j + 1, i + j + 1);
//                    }
//                    break;
//                }
//            }
//        }
//        return palindrome;
//    }
}
