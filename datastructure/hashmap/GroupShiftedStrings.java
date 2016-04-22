package datastructure.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) {
            return rst;
        }
        Arrays.sort(strings);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strings) {
            String shift = getShift(s);
            if (!map.containsKey(shift)) {
                map.put(shift, new ArrayList<String>());
            }
            map.get(shift).add(s);
        }
        for (String s : map.keySet()) {
            List<String> list = new ArrayList<String>();
            for (String orig : map.get(s)) {
                list.add(orig);
            }
            rst.add(list);
        }
        return rst;
    }
    private String getShift(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int diff = 0;
        diff = 'z' - s.charAt(0);
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            array[i] = (char)('a' + (array[i] - 'a' + diff) % 26);
        }
        return new String(array);
    }
}
