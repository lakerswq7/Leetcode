package datastructure.trie;

public class AddAndSearchWordDataStructureDesign {
	public class WordDictionary {
	    TrieNode root = new TrieNode();
	    // Adds a word into the data structure.
	    public void addWord(String word) {
	        TrieNode node = root;
	        for (int i = 0; i < word.length(); i++) {
	            if (node.keys[word.charAt(i) - 'a'] == null) {
	                node.keys[word.charAt(i) - 'a'] = new TrieNode();
	            }
	            node = node.keys[word.charAt(i) - 'a'];
	        }
	        node.isKey = true;
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	        return searchHelper(root, word);
	    }
	    
	    private boolean searchHelper(TrieNode root, String word) {
	        if (word.length() == 0) {
	            return root.isKey;
	        }
	        if (word.charAt(0) == '.') {
	            for (int i = 0; i < 26; i++) {
	                if (root.keys[i] != null && searchHelper(root.keys[i], word.substring(1))) {
	                    return true;
	                }
	            }
	            return false;
	        } else {
	            return root.keys[word.charAt(0) - 'a'] != null && searchHelper(root.keys[word.charAt(0) - 'a'], word.substring(1));
	        }
	    }
	}
	class TrieNode {
	    boolean isKey;
	    TrieNode[] keys;
	    TrieNode() {
	        keys = new TrieNode[26];
	    }
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
}
