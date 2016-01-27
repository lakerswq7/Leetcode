package string;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if ((haystack == null) || (needle == null)) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
//        构建失配函数
//        int[] T = new int[needle.length()];
//        for (int i = 0; i < needle.length(); i++) {
//            if (i == 0) {
//                T[i] = -1;
//            } else if (i == 1) {
//                T[i] = 0;
//            } else {
//                if (needle.charAt(i - 1) == needle.charAt(T[i - 1])) {
//                    T[i] = T[i - 1] + 1;
//                }
//            }
//        }
        int gap = 1;
        for (int i = 0; i < haystack.length(); i = i + gap) {
            for (int j = 0; j < needle.length(); j++) {
                if (i + j >= haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
//                	计算往后移的值
//                	gap = j - T[j];
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
    	String needle = "aa";
        String haystack = "aaa";
        ImplementStrStr sol = new ImplementStrStr();
        System.out.println(sol.strStr(haystack, needle));
    }
}
