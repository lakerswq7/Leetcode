package highfrequency;

public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int end = 0;
        int count = 0;
        while (count < n) {
            int read = read4(temp);
            end = Math.min(n - count, read);
            for (int i = 0; i < end; i++) {
                buf[count] = temp[i];
                count++;
            }
            if (end < 4) {
                break;
            }
        }
        return count;
    }
    public int read4(char[] buf) {
    	return 4;
    }
}
