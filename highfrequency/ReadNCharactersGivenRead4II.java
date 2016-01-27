package highfrequency;

public class ReadNCharactersGivenRead4II {
    private int start = 0;
    private int end = 0;
    private char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int count = 0;
        int c = end - start;
        while (count < n) {
            if (end == start) {
                c = read4(temp);
                start = 0;
            }
            end = start + Math.min(n - count, c);
            for (int i = start; i < end; i++) {
                buf[count] = temp[i];
                count++;
            }
            if ((end - start) < c) {
                c = c - (end - start);
                start = end;
                end = start + c;
            } else {
                c = 0;
                start = end;
            }
            if (end < 4) {
                break;
            }
        }
        return count;
    }
    private int s = 6;
    public int read4(char[] buf) {
    	s = s - 3;
    	if (s > 0) {
    		return s;
    	} else {
    		return 0;
    	}
    }
    public static void main(String[] args) {
    	ReadNCharactersGivenRead4II sol = new ReadNCharactersGivenRead4II();
    	char[] buf = new char[4];
    	System.out.println(sol.read(buf, 1));
    	System.out.println(sol.read(buf, 4));
    	System.out.println(sol.read(buf, 1));
    }
}
