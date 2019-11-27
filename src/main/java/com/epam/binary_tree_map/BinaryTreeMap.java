package com.epam.binary_tree_map;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BinaryTreeMap<K extends Comparable, V> implements Map<K, V> {

    private int size = 0;
    private Node<K, V> root;

    private static class Node<K, V> implements Entry<K, V> {

        private Node<K, V> left;
        private Node<K, V> right;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        try {
            Comparable<? super K> cKey = (Comparable<? super K>) key;
            Node<K, V> node = root;
            while (node != null) {
                int compResult = cKey.compareTo(node.key);
                if (compResult < 0) {
                    node = node.left;
                } else if (compResult > 0) {
                    node = node.right;
                } else {
                    return node.value;
                }
            }
            return null;
        } catch (ClassCastException e) {
            return null;
        }
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        runTreeForKeySet(root,set);
        return set;
    }

    private void runTreeForKeySet(Node<K,V> entryRoot, Set<K> set){
        if(entryRoot != null){
            runTreeForKeySet(entryRoot.left,set);
            set.add(entryRoot.getKey());
            runTreeForKeySet(entryRoot.right,set);
        }
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        runTreeForEntrySet(root,set);
        return set;
    }

    private void runTreeForEntrySet(Node<K,V> entryRoot, Set<Entry<K, V>> set){
        if(entryRoot != null){
            runTreeForEntrySet(entryRoot.left,set);
            set.add(entryRoot);
            runTreeForEntrySet(entryRoot.right,set);
        }
    }
}
