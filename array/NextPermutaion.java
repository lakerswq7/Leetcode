package array;

public class NextPermutaion {
    public void nextPermutation(int[] num) {
        if ((num == null) || (num.length <= 1)) {
            return;
        }
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                for (int j = num.length - 1; j > i; j--) {
                    if (num[j] > num[i]) {
                        swap(num, i, j);
                        reverse(num, i + 1, num.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(num, 0, num.length - 1);
    }
    public void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    public void reverse(int[] num, int begin, int end) {
        int temp;
        for (int i = 0; i <= (end - begin) / 2; i++) {
            temp = num[begin + i];
            num[begin + i] = num[end - i];
            num[end - i] = temp;
        }
    }
}
