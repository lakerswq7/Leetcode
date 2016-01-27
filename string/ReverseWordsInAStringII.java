package string;

public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int start = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] == ' ') {
                start = i + 1;
            } else if (i == s.length - 1 || s[i + 1] == ' ') {
                reverse(s, start, i);
            }
        }
        
        reverse(s, 0, s.length - 1);
    }
    public void reverse(char[] s, int start, int end) {
        char temp;
        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
