package datastructure.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordList = new ArrayList<String>();
        TrieNode root = buildTrie(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(board, visited, i, j, root, wordList);
            }
        }
        return wordList;
    }
    private void find(char[][] board, boolean[][] visited, int x, int y, TrieNode root, List<String> wordList) {
        int[] iX = {1, -1, 0, 0};
        int[] iY = {0, 0, -1, 1};

        if (root.keys[board[x][y] - 'a'] != null) {
            visited[x][y] = true;
            if (root.keys[board[x][y] - 'a'].word != null) {
                wordList.add(root.keys[board[x][y] - 'a'].word);
                root.keys[board[x][y] - 'a'].word = null;
            }
            for (int k = 0; k < 4; k++) {
                int newX = x + iX[k];
                int newY = y + iY[k];
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !visited[newX][newY]) {
                    find(board, visited, newX, newY, root.keys[board[x][y] - 'a'], wordList);
                }
            }
            visited[x][y] = false;
        }
        
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.keys[word.charAt(i) - 'a'] == null) {
                    node.keys[word.charAt(i) - 'a'] = new TrieNode();
                }
                node = node.keys[word.charAt(i) - 'a'];
            }
            node.word = word;
        }
        return root;
    }
    class TrieNode {
        String word;
        TrieNode[] keys;
        TrieNode() {
            word = null;
            keys = new TrieNode[26];
        }
    }
}
