package search.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class WordLadderII {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        if ((start == null) || (end == null) || (dict == null)) {
            return result;
        }
        HashMap<String, Node> map = new HashMap<String, Node>();
        getPre(start, end, map, dict);
        ArrayList<String> list = new ArrayList<String>();
        list.add(end);
        getLadder(result, list, start, end, map);
        return result;
    }
    public void getLadder(List<List<String>> result, List<String> list, String start, String end, HashMap<String, Node> map) {
        if (!map.containsKey(end)) {
            return;
        }
        Node temp = map.get(end);
        for (String pre : temp.pre) {
            list.add(0, pre);
            if (pre.equals(start)) {
                result.add(new ArrayList<String>(list));
            } else {
                getLadder(result, list, start, pre, map);
            }
            list.remove(0);
        }
    }
    public void getPre(String start, String end, HashMap<String, Node> map, Set<String> dict) {
        HashSet<String> dictionary = new HashSet<String>(dict);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dictionary.remove(start);
        int level = 2;
        boolean stop = false;
        
        while (!queue.isEmpty() && !stop) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < cur.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        String temp = transfer(cur, j, k);
                        if (temp.equals(end)) {
                            if (map.containsKey(temp)) {
                                map.get(temp).addPre(cur);
                            } else {
                                stop = true;
                                map.put(temp, new Node(level, cur));
                            }
                            continue;
                        }
                        if (map.containsKey(temp)) {
                            if (level == map.get(temp).level) {
                                map.get(temp).addPre(cur);
                            }
                        } else if (dictionary.contains(temp)) {
                            dictionary.remove(temp);
                            queue.offer(temp);
                            map.put(temp, new Node(level, cur));
                        }
                    }
                }
            }
            level++;
        }
    }
    public String transfer(String cur, int index, char replace) {
        StringBuilder temp = new StringBuilder(cur);
        temp.setCharAt(index, replace);
        return temp.toString();
    }
    class Node {
        int level;
        ArrayList<String> pre;
        Node(int level, String s) {
            this.level = level;
            pre = new ArrayList<String>();
            pre.add(s);
        }
        void addPre(String s) {
            pre.add(s);
        }
    }
//  Ö±¹ÛBFS + DFS£¬ TLE °æ±¾
//	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
//        List<List<String>> result = new ArrayList<List<String>>();
//        if ((start == null) || (end == null) || (dict == null)) {
//            return result;
//        }
//        HashSet<String> dict2 = new HashSet<String>(dict);
//        if (dict2.contains(start)) {
//            dict2.remove(start);
//        }
//        ArrayList<String> list = new ArrayList<String>();
//        list.add(start);
//        getLadders(result, list, start, end, dict2, ladderLength(start, end, dict2) - 1);
//        return result;
//    }
//    public void getLadders(List<List<String>> result, List<String> list, String start, String end, Set<String> dict, int n) {
//        if (n == 0) {
//            return;
//        }
//        for (int i = 0; i < start.length(); i++) {
//            for (char j = 'a'; j <= 'z'; j++) {
//                String temp = start.substring(0, i) + j + start.substring(i + 1, start.length());
//                if (temp.equals(end)) {
//                    list.add(end);
//                    result.add(new ArrayList<String>(list));
//                    return;
//                }
//                if (dict.contains(temp)) {
//                    dict.remove(temp);
//                    list.add(temp);
//                    getLadders(result, list, temp, end, dict, n - 1);
//                    list.remove(list.size() - 1);
//                    dict.add(temp);
//                }
//            }
//        }
//    }
//    public int ladderLength(String start, String end, Set<String> dict) {
//        if ((start == null) || (end == null) || (dict == null)) {
//            return 0;
//        }
//        HashSet<String> dictionary = new HashSet<String>(dict);
//        int len = 1;
//        Queue<String> queue = new LinkedList<String>();
//        queue.offer(start);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            len++;
//            for (int i = 0; i < size; i++) {
//                String cur = queue.poll();
//                for (int j = 0; j < cur.length(); j++) {
//                    for (char k = 'a'; k <= 'z'; k++) {
//                        String temp = cur.substring(0, j) + k + cur.substring(j + 1, cur.length());
//                        if (temp.equals(end)) {
//                            return len;
//                        }
//                        if (dictionary.contains(temp)){
//                            queue.offer(temp);
//                            dictionary.remove(temp);
//                        }
//                    }
//                }
//            }
//        }
//        return 0;
//    }
}
