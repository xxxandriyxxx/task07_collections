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

        @Override
        public String toString() {
            return "[" + key + ":" + value + "]";
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
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> parent;
        Node<K, V> tempParrent;
        if (root == null) {
            root = new Node<>(key, value);
        } else {
            tempParrent = root;
            int compResult;
            do {
                parent = tempParrent;
                compResult = key.compareTo(tempParrent.key);
                if (compResult < 0) {
                    tempParrent = tempParrent.left;
                } else if (compResult > 0) {
                    tempParrent = tempParrent.right;
                } else {
                    V oldValue = tempParrent.value;
                    tempParrent.value = value;
                    return oldValue;
                }
            } while (tempParrent != null);

            if (compResult < 0) {
                parent.left = new Node<>(key, value);
            } else if (compResult > 0) {
                parent.right = new Node<>(key, value);
            }
        }
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        K k = (K) key;
        Node<K, V> removingNode = root;
        Node<K, V> parent = root;
        Node<K, V> parentForChild = null;
        Node<K, V> childNode;
        if (root == null) {
            return null;
        } else {
            int compResult;
            do {
                compResult = k.compareTo(removingNode.key);
                if (compResult < 0) {
                    if (removingNode.left == null) {
                        return null;
                    }
                    parent = removingNode;
                    removingNode = removingNode.left;
                } else if (compResult > 0) {
                    if (removingNode.right == null) {
                        return null;
                    }
                    parent = removingNode;
                    removingNode = removingNode.right;
                } else {
                    break;
                }
            } while (true);

            if (removingNode.left == null && removingNode.right == null) {
                if (removingNode == root) {
                    root = null;
                } else if (parent.left == removingNode) {
                    parent.left = null;
                } else if (parent.right == removingNode) {
                    parent.right = null;
                }
            } else if (removingNode.left == null) {
                if (parent.left == removingNode) {
                    parent.left = removingNode.right;
                } else {
                    parent.right = removingNode.right;
                }
            } else if (removingNode.right == null) {
                if (parent.left == removingNode) {
                    parent.left = removingNode.left;
                } else {
                    parent.right = removingNode.left;
                }
            } else {
                childNode = removingNode.right;
                while (childNode.left != null) {
                    parentForChild = childNode;
                    childNode = childNode.left;
                }
                if (parentForChild != null) {
                    parentForChild.left = childNode.right;
                } else {
                    removingNode.right = null;
                }
                childNode.left = removingNode.left;
                childNode.right = removingNode.right;
                if (removingNode != root) {
                    if (parent.left == removingNode) {
                        parent.left = childNode;
                    } else {
                        parent.right = childNode;
                    }
                } else {
                    root = childNode;
                }
            }
            size--;
            return removingNode.getValue();
        }
    }


    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        runTreeForKeySet(root, set);
        return set;
    }

    private void runTreeForKeySet(Node<K, V> entryRoot, Set<K> set) {
        if (entryRoot != null) {
            runTreeForKeySet(entryRoot.left, set);
            set.add(entryRoot.getKey());
            runTreeForKeySet(entryRoot.right, set);
        }
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        runTreeForEntrySet(root, set);
        return set;
    }

    private void runTreeForEntrySet(Node<K, V> entryRoot, Set<Entry<K, V>> set) {
        if (entryRoot != null) {
            runTreeForEntrySet(entryRoot.left, set);
            set.add(entryRoot);
            runTreeForEntrySet(entryRoot.right, set);
        }
    }

}
