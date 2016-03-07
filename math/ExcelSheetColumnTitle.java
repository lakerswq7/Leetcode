package math;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder rst = new StringBuilder();
        while (n > 0) {
            n = n - 1;
            rst.append((char)('A' + (n % 26)));
            n /= 26;
        }
        return rst.reverse().toString();
    }
}
