package string;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null || version1.length() == 0 || version2.length() == 0) {
            return 0;
        }
        int i1 = 0, i2 = 0;
        int start1 = 0, start2 = 0;
        int m = version1.length();
        int n = version2.length();
        while (i1 < m || i2 < n) {
            int ver1 = 0, ver2 = 0;
            if (i1 < m) {
                while (i1 < m && version1.charAt(i1) != '.') {
                    i1++;
                }
                ver1 = new Integer(version1.substring(start1, i1));
                i1++;
                start1 = i1;
            }
            if (i2 < n) {
                while (i2 < n && version2.charAt(i2) != '.') {
                    i2++;
                }
                ver2 = new Integer(version2.substring(start2, i2));
                i2++;
                start2 = i2;
            }
            if (ver1 > ver2) {
                return 1;
            } else if (ver1 < ver2) {
                return -1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
    	String a = "12";
    	String[] b = a.split(".");
    	System.out.println(b.length);
    	for (String b1 : b) {
    		System.out.println(b1);
    	}
    }
}
