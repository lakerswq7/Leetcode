package highfrequency;

public class MajorityElement {
    public int majorityElement(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int element = 0;
        int count = 0;
        for (int n : num) {
            if (count == 0) {
                element = n;
                count++;
            } else {
                if (n == element) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return element;
    }
}
