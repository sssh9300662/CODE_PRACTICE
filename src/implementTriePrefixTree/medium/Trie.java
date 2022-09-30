package implementTriePrefixTree.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Trie {

    public Trie() {
        root = new Node(null);
    }

    private Node root;

    class Node {
        private Map<Character, Node> children = new HashMap<>();
        private Character value;
        private boolean isWord = false;
        public Node(Character value) {
            this.value = value;
        }
    }

    public void insert(String word) {
        if(word == "" || word == null){
            return;
        }
        word = word.trim();
        Node curr = root;
        for(int i=0; i < word.length(); i ++){
            Character c = word.charAt(i);
            if(curr.children.containsKey(c)){
                curr = curr.children.get(c);
            }else{
                Trie.Node child = new Trie.Node(c);
                curr.children.put(c, child);
                curr = child;
            }
        }
        curr.isWord = true; // last one
    }

    public boolean search(String word) {
        if(word == "" || word == null){
            return false;
        }
        word = word.trim();
        Node curr = root;
        for(int i=0; i < word.length(); i ++){
            Character c = word.charAt(i);
            if(curr.children.containsKey(c)){
                curr = curr.children.get(c);
            }else{
                return false;
            }
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        if(prefix == "" || prefix == null){
            return false;
        }
        prefix = prefix.trim();
        Node curr = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < prefix.length(); i ++){
            Character c = prefix.charAt(i);
            if(curr.children.containsKey(c)){
                curr = curr.children.get(c);
                sb.append(c);
            }else{
                break;
            }
        }
        return prefix.equals(sb.toString());
    }

    public static void main(String args[]){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        System.out.println(trie.startsWith("bcc")); // return False
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}
