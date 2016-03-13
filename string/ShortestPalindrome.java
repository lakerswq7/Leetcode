package string;

public class ShortestPalindrome {
	/*
	 * ÿ��startͣס���Ǹ����Լ�֮�󶼲������ڻ������Ҫ����ӵ�ǰ�档���ǲ��ܾʹ�ȷ���м䲿�־�һ���ǻ��ģ���Ҫ�ݹ���ã�
	 * ֱ��ȷ�����Լ����ǻ���Ϊֹ
	 */
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int start = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(start) == s.charAt(i)) {
                start++;
            }
        }
        if (start == s.length()) {
            return s;
        }
        String suffix = s.substring(start);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, start)) + suffix;
    }
}
