package com.gmail.vusketta;

import java.util.Arrays;
import java.util.Objects;

public class Trie {
    private final Node root;
    private static final int ALPHABET_SIZE = 26;

    public Trie() {
        this.root = new Node(' ');
    }

    public void insert(final String str) {
        insert(root, str);
    }

    public void remove(final String str) {
        remove(root, str);
    }

    public boolean contains(final String str) {
        return contains(root, str);
    }

    private void insert(final Node curr, final String str) {
        if (str.length() == 0 || !Character.isLetter(str.charAt(0))) {
            curr.isTerminal = true;
            return;
        }
        final char c = str.charAt(0);
        final int idx = getIndex(c);
        final Node node = curr.subtree[idx] != null ? curr.subtree[idx] : new Node(c);
        curr.subtree[idx] = node;
        insert(node, str.substring(1));
    }

    private void remove(final Node curr, final String str) {
        Node node = curr;
        for (int i = 0; i < str.length(); i++) {
            node = node.subtree[getIndex(str.charAt(i))];
        }
        node.isTerminal = false;
    }

    private boolean contains(final Node curr, final String str) {
        if (str.isEmpty() || !Character.isLetter(str.charAt(0))) return false;
        final Node node = curr.subtree[getIndex(str.charAt(0))];
        if (node == null) return false;
        if (str.length() == 1 && node.isTerminal) return true;
        return contains(node, str.substring(1));
    }

    private Node getPrefixNode(final String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            node = node.subtree[getIndex(prefix.charAt(i))];
        }
        return node;
    }

    private int getIndex(final char c) {
        return c - 'a';
    }

    private static class Node {
        private final char c;
        private Node[] subtree;
        private boolean isTerminal = false;

        public Node(final char c) {
            this.c = c;
            this.subtree = new Node[Trie.ALPHABET_SIZE];
        }

        @Override
        public String toString() {
            return String.valueOf(c);
        }
    }
}
