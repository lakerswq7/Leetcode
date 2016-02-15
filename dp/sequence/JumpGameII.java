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
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int step = 0;
        int max = 0;
        int lastMax = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, nums[i] + i);
            if (max >= nums.length - 1) {
                return step + 1;
            }
            if (i == lastMax) {
                lastMax = max;
                step++;
            }
        }
        return -1;
    }
}
