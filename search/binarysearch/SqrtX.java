package search.binarysearch;

public class SqrtX {
    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        }
        int low = 0;
        int high = x;
        int mid;
        long sqr;
        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            // ע��Ҫ�������long�����ֱ�Ӷ���midΪlong�����ڷ��ص�ʱ���������
            // �������long�����ұ߼������Ժ��ֱ������ٸ���sqr����ʹsqr��longҲ�Ѿ��Ǵ��ֵ
            sqr = (long)mid * mid;
            if (sqr == x) {
                return mid;
            }
            if (sqr > x) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (high * high == x) {
            return high;
        } else {
            return low;
        }
    }
}
