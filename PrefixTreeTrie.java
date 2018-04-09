/*
Author Satvik Dhandhania
Implement Trie (Prefix Tree)

Difficulty:Medium

Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z. 
*/
class Trie {
    
    class TrieNode{
        public Character c;
        public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        public boolean isEnd;
        
        
        public TrieNode(char c){
            this.c = c;
        }
        public TrieNode(){}
    }

    private TrieNode root; 
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
       HashMap<Character, TrieNode> children = root.children;
        TrieNode t;
        for(int i=0;i<word.length();i++){
           char c = word.charAt(i); 
           if(!children.containsKey(c)){
               t = new TrieNode(c);
               children.put(c,t);
           } else {
               t = children.get(c);
           }
            children = t.children;
            if(i == word.length()-1){
                t.isEnd = true;
            }
        }
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode t =searchNode(word);
        if(t!= null && t.isEnd){
            return true;
        }
        return false;
    }
    
    public TrieNode searchNode(String word){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i=0;i<word.length();i++){
           char c = word.charAt(i); 
           if(children.containsKey(c)){
               t = children.get(c);
               children = t.children;
           } else {
               return null;
           }
        }
        return t;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode t =searchNode(prefix);
        if(t!= null){
            return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */