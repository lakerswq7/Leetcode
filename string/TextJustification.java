package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justified = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return justified;
        }
        int charCount = 0;
        int len = words.length;
        int start = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || charCount + words[i].length() + i - start > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int wordCount = i - start;
                if (i == len || wordCount == 1) {
                    for (int j = start; j < i; j++) {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            sb.append(" ");
                        }
                    }
                    appendSpace(sb, maxWidth - sb.length());
                } else {
                    int spaceEach = (maxWidth - charCount) / (wordCount - 1);
                    int spaceExtra = (maxWidth - charCount) % (wordCount - 1);
                    for (int j = start; j < i; j++) {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(sb, spaceEach + (spaceExtra-- > 0 ? 1 : 0));
                        }
                    }
                }
                justified.add(sb.toString());
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
    private void appendSpace(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }
}
