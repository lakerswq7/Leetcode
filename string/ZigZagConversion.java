package string;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if ((s == null) || (s.length() == 0) || (nRows <= 1)) {
            return s;
        }
        StringBuilder zigZag = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += (2 * nRows - 2)) {
                zigZag.append(s.charAt(j));
                if ((i != 0) && (i != nRows - 1)) {
                    int pos = j + 2 * nRows - 2 - 2 * i;
                    if (pos < s.length()) {
                        zigZag.append(s.charAt(pos));
                    }
                }
            }
        }
        return zigZag.toString();
    }
    public static void main(String[] args) {
    	ZigZagConversion sol = new ZigZagConversion();
    	System.out.println(sol.convert("AB", 2));
    }
}
