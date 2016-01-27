package dp.sequence;

/*
 * 0. 没法sort， 求可能的解析方式， sequence -> dp
 * 1. f[i] -> 第i个字符的时候有多少种解析方式
 * 2. 如果第i个字符是0, 则：
 * 		如果第i - 1 个字符是 1或2， 则：f[i] = f[i - 2]
 * 		否则 f[i] = 0
 *	  如果第i个字符不是0， 则：
 *	  	如果第i - 1个字符是1，或者i - 1个字符是2且i个字符 <= 6，则f[i] = f[i - 1] + f[i - 2]
 *	  	否则 f[i] = f[i - 1]
 *    总结一下就是：
 *    如果第i个数能解析成数，即不是0， 则包含f[i - 1]
 *    如果第i - 1和第i个数组成的两位数是合法的，即这个数 10 <= x <=26 则再加上f[i - 2]
 * 3. f[0] = 1; f[1] = 1 如果第一个数不是0； f[1] = 0，如果第一个数是0
 * 4. f[n]
 * 
 * 注意： char的计算可以视为int的计算，
 * 对于字符串中出现0的位置要特别注意,这里需要讨论怎么处理，我这里的处理就是有非法的输入判定为不能解析，即解析结果为0, 如： 80
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if ((s == null) || s.equals("")) {
            return 0;
        }
        int n = s.length();
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int i = 1; i <= n; i++) {
            if ((s.charAt(i - 1) >= '1') && (s.charAt(i - 1) <= '9')) {
                ways[i] += ways[i - 1];
            }
            if (i > 1) {
                int num = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if ((num >= 10) && (num <= 26)) {
                    ways[i] += ways[i - 2];
                }
            }
        }
        return ways[n];
    }
}
