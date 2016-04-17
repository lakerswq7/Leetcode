package datastructure.hashmap;

import java.util.HashMap;
/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
 *
 */
public class UniqueWordAbbreviation {
	public class ValidWordAbbr {
	    HashMap<String, String> map;
	    public ValidWordAbbr(String[] dictionary) {
	        map = new HashMap<String, String>();
	        for (String s : dictionary) {
	            String abbr = transfer(s);
	            if (map.containsKey(abbr)) {
	                if (!map.get(abbr).equals(s)) {
	                    map.put(abbr, "");
	                }
	            } else {
	                map.put(abbr, s);
	            }
	        }
	    }

	    public boolean isUnique(String word) {
	        String abbr = transfer(word);
	        
	        if (map.containsKey(abbr) && !map.get(abbr).equals(word)) {
	            return false;
	        }
	        return true;
	    }
	    
	    private String transfer(String word) {
	        if (word.length() <= 2) {
	            return word;
	        } else {
	            StringBuilder sb = new StringBuilder();
	            sb.append(word.charAt(0));
	            sb.append(word.length() - 2);
	            sb.append(word.charAt(word.length() - 1));
	            return sb.toString();
	        }
	    }
	}
}
//Your ValidWordAbbr object will be instantiated and called as such:
//ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
//vwa.isUnique("Word");
//vwa.isUnique("anotherWord");
