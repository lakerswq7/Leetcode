package string;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder cur = new StringBuilder();
            int count = 1;
            for (int j = 0; j < result.length(); j++) {
                if ((j != result.length() - 1) && (result.charAt(j) == result.charAt(j + 1))) {
                    count++;
                } else {
                    cur.append(count);
                    cur.append(result.charAt(j));
                    count = 1;
                }
            }
            result = cur.toString();
        }
        return result;
    }
}
