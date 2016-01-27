package search.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null || s.length() == 0) {
            return null;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = s.length() - 1; i >= 0; i--) {
            ArrayList<String> sentence = new ArrayList<String>();
            String init = s.substring(i);
            if (dict.contains(init)) {
                sentence.add(init);
            }
            for (int j = i + 1; j < s.length(); j++) {
                String temp = s.substring(i, j);
                if (dict.contains(temp)) {
                    ArrayList<String> sents = map.get(s.substring(j));
                    for (String sen : sents) {
                        sentence.add(temp + " " + sen);
                    }
                }
            }
            map.put(init, sentence);
        }
        return map.get(s);
    }
// DP的思想，正面算就TLE，反面算就AC， test case的问题
//    public List<String> wordBreak(String s, Set<String> dict) {
//        if (s == null || dict == null || s.length() == 0) {
//            return null;
//        }
//        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
//        for (int i = 0; i < s.length(); i++) {
//            ArrayList<String> sentence = new ArrayList<String>();
//            String init = s.substring(0, i + 1);
//            if (dict.contains(init)) {
//                sentence.add(init);
//            }
//            for (int j = 0; j < i; j++) {
//                ArrayList<String> sents = map.get(s.substring(0, j + 1));
//                String temp = s.substring(j + 1, i + 1);
//                if (dict.contains(temp) && (sents.size() != 0)) {
//                    for (String sen : sents) {
//                        sentence.add(sen + " " + temp);
//                    }
//                }
//            }
//            map.put(init, sentence);
//        }
//        return map.get(s);
//    }
//	直观的DFS， TLE
//    public List<String> wordBreak(String s, Set<String> dict) {
//        List<String> result = new ArrayList<String>();
//        if ((s == null) || (dict == null) || (s.length() == 0)) {
//            return result;
//        }
//        getSentence(result, new StringBuilder(), dict, 0, s);
//        return result;
//    }
//    public void getSentence(List<String> result, StringBuilder sentences, Set<String> dict, int index, String s) {
//        if (index == s.length()) {
//            result.add(sentences.substring(1));
//            return;
//        }
//        for (int i = index; i < s.length(); i++) {
//            String temp = s.substring(index, i + 1);
//            if (dict.contains(temp)) {
//                sentences.append(" ");
//                sentences.append(temp);
//                getSentence(result, sentences, dict, i + 1, s);
//                sentences.delete(sentences.length() - temp.length() - 1, sentences.length());
//            }
//        }
//    }
}
