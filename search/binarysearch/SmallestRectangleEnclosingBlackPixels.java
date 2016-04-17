package search.binarysearch;
/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.
 */
public class SmallestRectangleEnclosingBlackPixels {
	/*
	 * 这其中在算小的边界的时候算的是第一个是1的
	 * 再算大的边界的时候算的是第一个不是1的
	 */
    public int minArea(char[][] image, int x, int y) {
        int minRow = bs(image, 0, x, true, true);
        int maxRow = bs(image, x, image.length, true, false);
        int minCol = bs(image, 0, y, false, true);
        int maxCol = bs(image, y, image[0].length, false, false);
        return (maxRow - minRow) * (maxCol - minCol);
    }
    private boolean hasOne(char[][] image, int line, boolean searchRow) {
        for (int i = 0; i < (searchRow ? image[0].length : image.length); i++) {
            if ((searchRow ? image[line][i] : image[i][line]) == '1') {
                return true;
            }
        }
        return false;
    }
    private int bs(char[][] image, int low, int high, boolean searchRow, boolean searchMin) {
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (hasOne(image, mid, searchRow)) {
                if (searchMin) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (searchMin) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return low;
    }
}
