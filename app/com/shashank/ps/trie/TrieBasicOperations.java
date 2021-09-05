package com.shashank.ps.trie;

public class TrieBasicOperations {

    private static final TrieBasicOperations tbo = new TrieBasicOperations();

    public static void main(String[] args) {
        TrieNode trieNode = new TrieNode();
        tbo.insert(trieNode, "ball");
        tbo.insert(trieNode, "bill");
        tbo.insert(trieNode, "bat");
        tbo.insert(trieNode, "cat");
        tbo.insert(trieNode, "cater");
        tbo.insert(trieNode, "com");
        tbo.insert(trieNode, "commerce");

        System.out.println("Is 'ball' present: " + tbo.search(trieNode, "ball"));
        System.out.println("Is 'bill' present: " + tbo.search(trieNode, "bill"));
        System.out.println("Is 'cat' present: " + tbo.search(trieNode, "cat"));
        System.out.println("Is 'commerce' present: " + tbo.search(trieNode, "commerce"));
        System.out.println("Is 'com' present: " + tbo.search(trieNode, "com"));
        System.out.println("Is 'com1' present: " + tbo.search(trieNode, "com1"));
        System.out.println("Is 'max' present: " + tbo.search(trieNode, "max"));
        System.out.println("Is 'baller' present: " + tbo.search(trieNode, "baller"));

        tbo.delete(trieNode, "commerce", 0);
        tbo.delete(trieNode, "com1", 0);
        System.out.println("Is 'com' present: " + tbo.search(trieNode, "com"));
        System.out.println("Is 'commerce' present: " + tbo.search(trieNode, "commerce"));

    }

    public void insert(TrieNode root, String word) {
        TrieNode curr = root;

        for (char l: word.toCharArray()) {
            String content = curr.getContent() == null ? "": curr.getContent();
            curr = curr.getChildren().computeIfAbsent(l, c -> new TrieNode());
            curr.setContent(content + l);
        }
        curr.setWordComplete(true);
    }

    public boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isWordComplete()) {
                return false;
            }
            current.setWordComplete(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index+1) && !node.isWordComplete();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    public boolean search(TrieNode root, String word) {
        TrieNode curr = root;
        for (char l: word.toCharArray()) {
            TrieNode node = curr.getChildren().get(l);
            if (node == null) {
                return false;
            }
            curr = node;
        }
        return true;
    }

    public TrieNode searchEndNode(TrieNode root, String word) {
        TrieNode curr = root;
        for (char l: word.toCharArray()) {
            TrieNode node = curr.getChildren().get(l);
            if (node == null) {
                return node;
            }
            curr = node;
        }
        return curr;
    }
}
