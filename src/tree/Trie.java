package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现字典树
 */
public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
        root.value = '\\';
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node head = root;
        char[] words = word.toCharArray();
        int i = 0;
        // trie中有前缀继续往后走
        while (head != null && i < word.length() && head.childNodes.containsKey(words[i])) {
            head = head.childNodes.get(words[i]);
            i++;
            if (i == words.length) {
                head.end = true;
            }
        }

        while (i < word.length()) {
            Node newNode = new Node();
            newNode.value = words[i];
            head.childNodes.put(words[i], newNode);
            head = newNode;
            i++;
            if (i == word.length()) {
                newNode.end = true;
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = findNode(word);
        if (node == null) {
            return false;
        }
        return node.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (findNode(prefix) == null) {
            return false;
        }

        return true;
    }

    public Node findNode(String word) {
        Node head = root;
        for (char c : word.toCharArray()) {
            if (head.childNodes.containsKey(c)) {
                head = head.childNodes.get(c);
            } else {
                return head;
            }
        }
        return null;
    }

    class Node {
        public char value;
        public Map<Character, Node> childNodes = new HashMap<>(26);
        public boolean end = false;
    }
}
