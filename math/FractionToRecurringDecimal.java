package math;

import java.util.HashMap;
// ������������һ��Ҫע��corner case�� ��-2147483648�� һ��Ҫ�ȱ��long����ȡ����ֵ�ٸ���long
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return null;
        }
        StringBuilder rst = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            rst.append('-');
        }
        long nume = Math.abs((long)numerator);
        long deno = Math.abs((long)denominator);
        rst.append(nume / deno);
        long remain = nume % deno;
        if (remain > 0) {
            rst.append('.');
        }
        StringBuilder decimal = new StringBuilder();
        HashMap<Long, Integer> dup = new HashMap<Long, Integer>();
        int index = 0;
        while (remain > 0) {
            if (dup.containsKey(remain)) {
                decimal.insert(dup.get(remain), "(");
                decimal.append(')');
                break;
            }
            dup.put(remain, index++);
            decimal.append(remain * 10 / deno);
            remain = remain * 10 % deno;
        }
        return rst.append(decimal).toString();
    }
}
