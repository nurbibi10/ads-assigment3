import java.util.ArrayList;
import java.util.List;

public class BinaryST<K extends Comparable<K>, V> {
    private Node root;
    private int s;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node current, K key, V val) {
        if (current == null) {
            s++;
            return new Node(key, val);
        }
        int c = key.compareTo(current.key);
        if (c < 0)
            current.left = put(current.left, key, val);
        else if (c > 0)
            current.right = put(current.right, key, val);
        else
            current.val = val;
        return current;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node current, K key) {
        if (current == null) return null;
        int c = key.compareTo(current.key);
        if (c < 0)
            return get(current.left, key);
        else if (c > 0)
            return get(current.right, key);
        else
            return current.val;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node current, K key) {
        if (current == null)
            return null;
        int c = key.compareTo(current.key);
        if (c < 0)
            current.left = delete(current.left, key);
        else if (c > 0)
            current.right = delete(current.right, key);
        else {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                s--;
                return current.left;
            }
            if (current.left == null) {
                s--;
                return current.right;
            }
            Node t = current;
            current = min(t.right);
            current.right = deletemin(t.right);
            current.left = t.left;
            s--;
        }
        return current;
    }

    public void deletemin() {
        root = deletemin(root);
    }

    private Node deletemin(Node current) {
        if (current.left == null)
            return current.right;
        current.left = deletemin(current.left);
        return current;
    }

    public K min() {
        Node minNode = min(root);
        return minNode == null ? null : minNode.key;
    }

    private Node min(Node current) {
        if (current == null || current.left == null)
            return current;
        else
            return min(current.left);
    }

    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
    }

    private void inOrder(Node current, List<K> keys) {
        if (current == null) return;
        inOrder(current.left, keys);
        keys.add(current.key);
        inOrder(current.right, keys);
    }

    public int size() {
        return s;
    }
}