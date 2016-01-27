package dp.sequence;

/*
 * 0. ������������С������ sequence -> dp
 * 1. f[i] -> ����i����ʱ����Զ����������
 * 2. f[i] = max(j + A[j]), f[i - 2] < j <= f[i - 1], �����f[i] <= f[i - 1] �򷵻�-1
 * 3. f[0] = 0, f[1] = A[0]
 * 4. ������f[i] >= n - 1������i
 * 
 * �Ż�����Ϊֻ��ǰ������ֵ�йأ����Կ���ֻ������������
 */
public class JumpGameII {
    public int jump(int[] A) {
        if ((A == null) || (A.length <= 1)) {
            return 0;
        }
        int last = -1;
        int max = 0;
        int jump = 0;
        
        for (int i = 0; i <= max; i++) {
            if (i > last) {
                last = max;
                jump++;
            }
            max = Math.max(max, i + A[i]);
            if (max >= A.length - 1) {
                return jump;
            }
        }
        return -1;
    }
}
