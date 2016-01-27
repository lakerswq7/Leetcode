package string;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if ((num1 == null) || (num2 == null) || (num1.length() == 0) || (num2.length() == 0)) {
            return null;
        }
        int m = num1.length();
        int n = num2.length();
        int[] product = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int temp = product[i + j + 1] + (n1 * n2);
                product[i + j + 1] = temp % 10;
                product[i + j] += temp / 10;
            }
        }
        StringBuilder rst = new StringBuilder();
        int i = 0;
        while ((i < product.length - 1) && (product[i] == 0)) {
            i++;
        }
        for (; i < product.length; i++) {
            rst.append(product[i]);
        }
        return rst.toString();
    }
}
