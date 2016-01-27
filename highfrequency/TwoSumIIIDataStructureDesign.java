package highfrequency;

import java.util.HashMap;

public class TwoSumIIIDataStructureDesign {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public void add(int number) {
	    if(map.containsKey(number)) {
	        map.put(number, map.get(number) + 1);
	    } else {
	        map.put(number, 1);
	    }
	}

	public boolean find(int value) {
	    for (int element : map.keySet()) {
	        int com = value - element;
	        if ((element == com && map.get(element) > 1) || (element != com && map.containsKey(com))) {
	            return true;
	        }
	    }
	    return false;
	}
}