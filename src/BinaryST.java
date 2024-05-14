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
        int c = key.compareTo(current.key);
        if (current == null) {
            return null;
        }
        if (c < 0)
            return get(current.left, key);
        else if (c > 0)
            return get(current.right, key);

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
            current.left  = delete(current.left,  key);
        else if (c > 0)
            current.right = delete(current.right, key);
        else {
            if (current.left == null && current.right == null) {
                return null;
            }
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

    public void deletemin(){
        root = deletemin(root);
    }

    private Node deletemin(Node current) {
        if (current.left == null)
            return current.right;
        current.left = deletemin(current.left);
        return current;
    }

    public K Min(){
        return Min(root).key;
    }

    private Node Min(Node current) {
        if (current.left == null)
            return null;
        else
            return Min(current);
    }

    public Iterable<K> iterator(){
        return null;
    }
}
