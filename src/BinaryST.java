import org.w3c.dom.Node;

public class BinaryST<K extends Comparable<K>, V> {
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val){
        root = put(root, key, val);
    }

    private Node put(Node current, K key, V val) {
        if (current == null)
            return new Node(key, val);
        int cm = key.compareTo(current.key);
        if (cm < 0)
            current.left = put(current.left, key, val);
        else if (cm > 0)
            current.right = put(current.right, key, val);
        else
            current.val = val;
        return current;
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else
                return current.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node current, K key) {
        if (current == null)
            return null;
        int cmp = key.compareTo(current.key);
        if (cmp < 0)
            current.left  = delete(current.left,  key);
        else if (cmp > 0)
            current.right = delete(current.right, key);
        else {
            if (current.right == null)
                return current.left;
            if (current.left  == null)
                return current.right;
            Node t = current;
            current = Min(t.right);
            current.right = deletemin(t.right);
            current.left = t.left;
        }
        return current;
    }

    private Node deletemin(Node current) {
        if (current.left == null)
            return current.right;
        current.left = deletemin(current.left);
        return current;
    }

    private Node Min(Node current) {
        if (current.left == null)
            return current;
        else
            return Min(current.left);
    }

    public Iterable<K> iterator(){

    }
}
