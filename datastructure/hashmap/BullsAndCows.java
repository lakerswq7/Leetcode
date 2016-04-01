package datastructure.hashmap;

import java.util.HashMap;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                if (map.containsKey(secret.charAt(i))) {
                    map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
                } else {
                    map.put(secret.charAt(i), 1);
                }
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (map.containsKey(guess.charAt(i))) {
                    cow++;
                    if (map.get(guess.charAt(i)) == 1) {
                        map.remove(guess.charAt(i));
                    } else {
                        map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bull);
        sb.append("A");
        sb.append(cow);
        sb.append("B");
        return sb.toString();
    }
}
