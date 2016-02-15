package string;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n < 1) {
            return null;
        }
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = 0; j < result.length(); j++) {
                count++;
                if (j == result.length() - 1 || result.charAt(j) != result.charAt(j + 1)) {
                    sb.append(count);
                    sb.append(result.charAt(j));
                    count = 0;
                }
            }
            result = sb.toString();
        }
        return result;
    }
}
