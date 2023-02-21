package com.gmail.vusketta;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie);
        trie.insert("dad");
        trie.insert("daddy");
        System.out.println(trie);
        System.out.println(trie.contains("dad"));
        System.out.println(trie.contains("da"));
        trie.remove("dad");
        System.out.println(trie.contains("dad"));
        System.out.println(trie.contains("daddy"));
        System.out.println("Hello world!");
    }
}