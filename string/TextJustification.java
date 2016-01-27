package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> justified = new ArrayList<String>();
        if (words == null) {
            return null;
        }
        int len = words.length;
        int charCount = 0;
        int start = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || charCount + words[i].length() + i - start > L) {
                StringBuilder buf = new StringBuilder();
                int wordCount = i - start;
                if (wordCount == 1 || i == len) {
                    for (int j = start; j < i; j++) {
                        buf.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(buf, 1);
                        }
                    }
                    appendSpace(buf, L - buf.length());
                } else {
                    int spaceEach = (L - charCount) / (wordCount - 1);
                    int spaceExtra = (L - charCount) % (wordCount - 1);
                    for (int j = start; j < i; j++) {
                        buf.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(buf, (j - start) < spaceExtra ? spaceEach + 1 : spaceEach);
                        }
                    }
                }
                justified.add(buf.toString());
                start = i;
                if (i != len) {
                    charCount = words[i].length();
                }
            } else {
                charCount += words[i].length();
            }
        }
        return justified;
    }
    private void appendSpace(StringBuilder s, int count) {
        for (int i = 0; i < count; i++) {
            s.append(' ');
        }
    }
}
