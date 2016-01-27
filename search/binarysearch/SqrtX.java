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
            // 注意要在这里加long，如果直接定义mid为long，则在返回的时候会编译错误
            // 如果不加long，则右边计算完以后就直接溢出再赋给sqr，即使sqr是long也已经是错的值
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
