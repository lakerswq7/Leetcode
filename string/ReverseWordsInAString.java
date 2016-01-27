package string;


public class ReverseWordsInAString {
    public String reverseWords(String s) {
    	if (s == null)
    		return null;
    	s = s.trim();
    	if (s.length() == 0)
    	    return s;
        StringBuffer buf = new StringBuffer();
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() == 0)
                continue;
            buf.append(words[i]);
            if (i != 0)
            	buf.append(" ");
        }
        return buf.toString();
    }
    
    // 如果不用split和trim函数的办法
    public String reverseWords2(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder reverse = new StringBuilder();
        int end = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                end = i;
            } else if ((i == 0) || (s.charAt(i - 1) == ' ')) {
                if (reverse.length() != 0) {
                    reverse.append(' ');
                }
                reverse.append(s.substring(i, end));
            }
        }
        return reverse.toString();
    }
	public static void main(String[] args) {
		ReverseWordsInAString solve = new ReverseWordsInAString();
		String s = "I am a book";
		String result = solve.reverseWords(s);
		System.out.println(result);
	}
}

