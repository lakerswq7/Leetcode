package math;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return null;
        }
        StringBuilder rst = new StringBuilder();
        while (n > 0) {
        	int remainder = n % 26;
        	if (remainder == 0) {
        		rst.append('Z');
        		n = n / 26 - 1;
        	} else {
        		rst.append((char)('A' + remainder - 1));
        		n = n / 26;
        	}
        }
        return rst.reverse().toString();
    }
}
