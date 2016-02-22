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
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
