package search.binarysearch;

public class SqrtX {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int low = 1, high = x;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            // ע��Ҫ�������long�����ֱ�Ӷ���midΪlong�����ڷ��ص�ʱ���������
            // �������long�����ұ߼������Ժ��ֱ������ٸ���sqr����ʹsqr��longҲ�Ѿ��Ǵ��ֵ
            long sqr = (long)mid * mid;
            if (sqr == x) {
                return mid;
            } else if (sqr < x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
