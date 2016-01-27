package highfrequency;

public class SingleNumberII {
    public int singleNumber(int[] A) {
        if ((A == null) || (A.length == 0)) {
            return -1;
        }
        int[] array = new int[32];
        for (int a : A) {
            for (int i = 0; i < 32; i++) {
                array[i] += 1 & (a >> i);
                if (array[i] == 3) {
                    array[i] = 0;
                }
            }
        }
        return parse(array);
    }
    public int parse(int[] array) {
        int a = 0;
        for (int i = 31; i >= 0; i--) {
            a = a * 2 + array[i];
        }
        return a;
    }
}
