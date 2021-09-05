package com.shashank.ps.trie;

import java.util.Map;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        TrieBasicOperations tbo = new TrieBasicOperations();
        TrieNode trieNode = new TrieNode();
        tbo.insert(trieNode, "code");
        tbo.insert(trieNode, "coder");
        tbo.insert(trieNode, "codex");
        tbo.insert(trieNode, "coding");

        StringBuilder prefix = new StringBuilder();
        getLongestCommonPrefix(trieNode, prefix);

        System.out.println("".equals(prefix.toString()) ? "No Common Prefix Found.": prefix);
    }

    private static void getLongestCommonPrefix(TrieNode root, StringBuilder prefix) {
        TrieNode curr = root;

        while (curr != null && curr.getChildren() != null && !curr.isWordComplete() && curr.getChildren().size() == 1) {
            for (Map.Entry<Character, TrieNode> entry : curr.getChildren().entrySet()) {
                prefix.append(entry.getKey());
                curr = entry.getValue();
            }
        }
    }
}
