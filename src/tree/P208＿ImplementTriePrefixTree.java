/**
A trie (pronounced as "try") or prefix tree is a tree data structure used to 
efficiently store and retrieve keys in a dataset of strings. There are various 
applications of this data structure, such as autocomplete and spellchecker. 

 Implement the Trie class: 

 
 Trie() Initializes the trie object. 
 void insert(String word) Inserts the string word into the trie. 
 boolean search(String word) Returns true if the string word is in the trie (i.
e., was inserted before), and false otherwise. 
 boolean startsWith(String prefix) Returns true if there is a previously 
inserted string word that has the prefix prefix, and false otherwise. 
 

 
 Example 1: 

 
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

 
 Constraints: 

 
 1 <= word.length, prefix.length <= 2000 
 word and prefix consist only of lowercase English letters. 
 At most 3 * 10⁴ calls in total will be made to insert, search, and startsWith. 

 

 Related Topics Hash Table String Design Trie 👍 11475 👎 141

*/

package tree;


import java.util.HashMap;
import java.util.Map;

class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isWord = false;
}

class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Node current = root;
        for(int i=0; i < word.length(); i++){
            Character c = word.charAt(i);
            Map<Character, Node> children = current.children;
            // 如果子節點有此字元，則不需新增節點
            if (children.get(c) != null) {
                current = children.get(c);
            } else {
                // 否則就在目前的節點下新增此字元的子節點
                current = new Node();
                children.put(c, current);
            }
        }
        // 遍歷到最後一個字元時，將該節點的 isWord 標示為 true
        // 表示如果從 root 走到這個節點時，目前組合的字串是之前插入過的
        current.isWord = true;
    }

    private Node findLastNode(String word){
        if (word == null || word.length() == 0 || root.children.size() == 0) {
            return null;
        }
        Node current = root;
        for(int i=0; i < word.length(); i++){
            Character c = word.charAt(i);
            Map<Character, Node> children = current.children;
            if(children.containsKey(c)){
                current = children.get(c);
            }else{
                return null;
            }
        }
        return current;
    }

    public boolean search(String word) {
        Node node = findLastNode(word);
        if(node == null){
            return false;
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        Node node = findLastNode(prefix);
        return node != null;
    }
}

public class P208＿ImplementTriePrefixTree{
    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "apple";
        String prefix = "app";
        obj.insert(word);
        System.out.println(obj.search(word));
        System.out.println(obj.startsWith(prefix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}