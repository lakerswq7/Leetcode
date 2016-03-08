package datastructure.trie;

public class ImplementTrie {
	class TrieNode {
	    // Initialize your data structure here.
	    boolean isKey;
	    TrieNode[] keys;
	    public TrieNode() {
	        keys = new TrieNode[26];
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        TrieNode node = root;
	        for (int i = 0; i < word.length(); i++) {
	            if (node.keys[word.charAt(i) - 'a'] == null) {
	                node.keys[word.charAt(i) - 'a'] = new TrieNode();
	            }
	            node = node.keys[word.charAt(i) - 'a'];
	        }
	        node.isKey = true;
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode node = root;
	        for (int i = 0; i < word.length(); i++) {
	            if (node.keys[word.charAt(i) - 'a'] == null) {
	                return false;
	            }
	            node = node.keys[word.charAt(i) - 'a'];
	        }
	        return node.isKey;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        TrieNode node = root;
	        for (int i = 0; i < prefix.length(); i++) {
	            if (node.keys[prefix.charAt(i) - 'a'] == null) {
	                return false;
	            }
	            node = node.keys[prefix.charAt(i) - 'a'];
	        }
	        return true;
	    }
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
