package math;

public class AddBinary {
    public String addBinary(String a, String b) {
        if ((a == null) || (b == null)) {
            return null;
        }
        StringBuilder rst = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        while ((aIndex >= 0) || (bIndex >= 0)) {
            int sum = 0;
            if (aIndex >= 0) {
                sum += a.charAt(aIndex) - '0';
                aIndex--;
            }
            if (bIndex >= 0) {
                sum += b.charAt(bIndex) - '0';
                bIndex--;
            }
            sum += carry;
            carry = sum / 2;
            rst.append(sum % 2);
        }
        if (carry == 1) {
            rst.append(carry);
        }
        return rst.reverse().toString();
    }
}
