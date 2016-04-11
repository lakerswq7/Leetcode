package search.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	/*
	 * DFS解法，另外一种更简单的解法是，最后直接把最后的点加到结果里去，
	 * 如果这条是死路的话，那这些点本来就应该放在最后的
	 */
	public class Solution {
	    public List<String> findItinerary(String[][] tickets) {
	        List<String> rst = new ArrayList<String>();
	        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	        for (String[] ticket : tickets) {
	            if(!map.containsKey(ticket[0])) {
	                map.put(ticket[0], new ArrayList<String>());
	            }
	            map.get(ticket[0]).add(ticket[1]);
	        }
	        for (ArrayList<String> airports : map.values()) {
	            Collections.sort(airports);
	        }
	        int num = tickets.length + 1;
	        String cur = "JFK";
	        ArrayList<String> list = new ArrayList<String>();
	        list.add(cur);
	        helper(rst, list, cur, num, map);
	        return rst;
	    }
	    private boolean helper(List<String> rst, List<String> list, String cur, int num, HashMap<String, ArrayList<String>> map) {
	        if (list.size() == num) {
	            rst.addAll(list);
	            return true;
	        }
	        if (!map.containsKey(cur) || map.get(cur).size() == 0) {
	            return false;
	        }
	        ArrayList<String> temp = map.get(cur);
	        for (int i = 0; i < temp.size(); i++) {
	            cur = temp.get(i);
	            temp.remove(i);
	            list.add(cur);
	            if (helper(rst, list, cur, num, map)) {
	                return true;
	            }
	            list.remove(list.size() - 1);
	            temp.add(i, cur);
	        }
	        return false;
	    }
	    
	    
	    public List<String> findItinerary2(String[][] tickets) {
	        List<String> rst = new ArrayList<String>();
	        HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	        for (String[] ticket : tickets) {
	            if(!map.containsKey(ticket[0])) {
	                map.put(ticket[0], new PriorityQueue<String>());
	            }
	            map.get(ticket[0]).offer(ticket[1]);
	        }
	        dfs("JFK", rst, map);
	        return rst;
	    }
	    private void dfs(String cur, List<String> rst, HashMap<String, PriorityQueue<String>> map) {
	        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
	            dfs(map.get(cur).poll(), rst, map);
	        }
	        rst.add(0, cur);
	    }
	}
}
