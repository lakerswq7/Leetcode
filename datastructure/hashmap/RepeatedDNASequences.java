package datastructure.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        HashMap<Integer, Integer> seq = new HashMap<Integer, Integer>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int key = 0;
        int mask = (1 << 20) - 1;
        if (s == null || s.length() <= 10) {
            return result;
        }
        
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        // 因为只有4个候选，所以做了四进制编码, 其实没有必要，HashMap里就放String就行了
        for (int i = 0; i < s.length(); i++) {
            key = ((key << 2) + map.get(s.charAt(i))) & mask;
            if (i >= 9) {
                if (seq.containsKey(key)) {
                    if (seq.get(key) == 1) {
                        result.add(s.substring(i - 9, i + 1));
                    }
                    seq.put(key, seq.get(key) + 1);
                } else {
                    seq.put(key, 1);
                }
            }
        }
        return result;
    }
}
