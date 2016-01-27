package highfrequency;

public class SingleNumber {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int element : A) {
            result ^= element;
        }
        return result;
    }
}
