package array;

public class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) {
            return 0;
        }
        int[] count = new int[len + 1];
        for (int c : citations) {
            if (c >= len) {
                count[len]++;
            } else {
                count[c]++;
            }
        }
        int temp = 0;
        for (int i = len; i >= 0; i--) {
            temp += count[i];
            if (temp >= i) {
                return i;
            }
        }
        return 0;
    }
}
