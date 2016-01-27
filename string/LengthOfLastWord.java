package string;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int index = s.length() - 1;
        while (index >= 0) {
            if (s.charAt(index) == ' ') {
                return s.length() - index - 1;
            }
            index--;
        }
        return s.length();
    }
}
