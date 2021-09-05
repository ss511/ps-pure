package com.shashank.ps.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Auto Complete suggestion based on prefix.
 */
public class AutoComplete {
    static TrieBasicOperations tbo = new TrieBasicOperations();
    public static void main(String[] args) {

        TrieNode trieNode = new TrieNode();
        tbo.insert(trieNode, "ball");
        tbo.insert(trieNode, "bill");
        tbo.insert(trieNode, "bat");
        tbo.insert(trieNode, "base");
        tbo.insert(trieNode, "batter");
        tbo.insert(trieNode, "bake");
        tbo.insert(trieNode, "cat");
        tbo.insert(trieNode, "cater");
        tbo.insert(trieNode, "com");
        tbo.insert(trieNode, "commerce");
        tbo.insert(trieNode, "dog");
        tbo.insert(trieNode, "dome");
        tbo.insert(trieNode, "dose");
        tbo.insert(trieNode, "dock");
        tbo.insert(trieNode, "dash");
        tbo.insert(trieNode, "damp");

        String word = "ba";

        TrieNode prefix = tbo.searchEndNode(trieNode, word);
        List<String> suggestions = new ArrayList<>();
        getAutoCompleteSuggestion(prefix, suggestions);
        suggestions.forEach(System.out::println);

    }

    private static void getAutoCompleteSuggestion(TrieNode root, List<String> suggestions) {

        if (root != null && root.isWordComplete()) {
            suggestions.add(root.getContent());
        }

        if (root == null || root.getChildren() == null || root.getChildren().isEmpty()) {
            return;
        }

        for (TrieNode node: root.getChildren().values()) {
            getAutoCompleteSuggestion(node, suggestions);
        }


    }

}
