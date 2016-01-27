package highfrequency;

public class SortColors {
    public void sortColors(int[] A) {
        if ((A == null) || (A.length == 0)) {
            return;
        }
        int red = 0;
        int blue = A.length - 1;
        int white = 0;
        while (white <= blue) {
            if (A[white] == 0) {
                swap(white, red, A);
                white++;
                red++;
            } else if (A[white] == 1) {
                white++;
            } else {
                swap(white, blue, A);
                blue--;
            }
        }
    }
    public void swap(int a, int b, int[] A) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
