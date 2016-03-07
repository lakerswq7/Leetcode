package highfrequency;

public class ReadNCharactersGivenRead4II {
    char[] cache = new char[4];
    int start = 0;
    int end = 0;
    public int read(char[] buf, int n) {
        int already = 0;
        for (int i = 0; i < n && start != end; i++) {
            buf[already] = cache[start];
            start = (start + 1) % 4;
            already++;
        }
        char[] temp = new char[4];
        while (already < n) {
            int read = read4(temp);
            int count = Math.min(n - already, read);
            for (int i = 0; i < count; i++) {
                buf[already] = temp[i];
                already++;
            }
            for (int i = count; i < read; i++) {
                cache[end] = temp[i];
                end = (end + 1) % 4;
            }
            if (count < 4) {
                break;
            }
        }
        return already;
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
