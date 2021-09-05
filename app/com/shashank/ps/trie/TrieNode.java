package com.shashank.ps.trie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrieNode {

    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean isWordComplete;
    private String content;
}
