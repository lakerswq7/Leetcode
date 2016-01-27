package math;

import java.util.HashMap;
// ������������һ��Ҫע��corner case�� ��-2147483648�� һ��Ҫ�ȱ��long����ȡ����ֵ�ٸ���long
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return null;
        }
        StringBuilder rst = new StringBuilder();
        StringBuilder decimal = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            rst.append('-');
        }
        long numer = Math.abs((long)numerator);
        long denomin = Math.abs((long)denominator);
        rst.append(numer / denomin);
        long remain = numer % denomin;
        if (remain != 0) {
            rst.append('.');
        }
        int index = 0;
        while(remain != 0) {
            if (!map.containsKey(remain)) {
                map.put(remain, index);
            } else {
                decimal.insert(map.get(remain), "(");
                decimal.append(')');
                break;
            }
            remain *= 10;
            decimal.append(remain / denomin);
            index++;
            remain %= denomin;
        }
        rst.append(decimal);
        return rst.toString();
    }
}
