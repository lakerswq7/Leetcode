package math;

public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();
        String[] bit = {" Billion", " Million", " Thousand", ""};
        int mask = 1000000000;
        for (int i = 0; num > 0; i++) {
            int temp = num / mask;
            if (temp != 0) {
                sb.append(getNum(temp));
                sb.append(bit[i]);
            }
            num = num % mask;
            mask /= 1000;
        }
        if (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    private String getNum(int num) {
        String[] digit = {" One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
        String[] tens = {" Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
        String[] ten = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(digit[num / 100 - 1]);
            sb.append(" Hundred");
            num = num % 100;
        }
        if (num / 10 == 1) {
            sb.append(ten[num - 10]);
        } else {
            if (num / 10 != 0) {
                sb.append(tens[num / 10 - 2]);
                num = num % 10;
            }
            if (num != 0) {
                sb.append(digit[num - 1]);
            }
        }
        return sb.toString();
    }
}
