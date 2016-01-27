package dp.sequence;
/*
 * 0. �����������ܲ���������sequence -> dp
 * 1. f[i] -> �ڵ�i��λ��ʱ��Զ��������
 * 2. f[i] = max(f[i - 1], i + A[i])����i <= f[i - 1]�����򷵻�false
 * 3. f[0] = A[0]
 * 4. �������f[i] >= n - 1���򷵻�true
 * �Ż�����Ϊֻ��ǰ��һ��ֵ�йأ����Կ��Բ������飬ֻ��һ��������
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + A[i]);
                if (max >= A.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
