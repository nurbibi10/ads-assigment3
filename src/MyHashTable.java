public class MyHashTable<K, V>{
    public class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode<K, V> getNext() {
            return next;
        }
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{"+ key + " " + value + "}";
        }
    }
    HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }


    public MyHashTable(int M){
        this.M = M;
        this.chainArray = (HashNode<K, V>[]) new HashNode[M];
        this.size = 0;
    }

    private int hash(K key){
        int hash = key.hashCode();
        return Math.abs(hash % M);
    }

    public void put(K key, V value){
        int ind = hash(key);
        HashNode<K, V> n = chainArray[ind];
        while (n != null) {
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
            n = n.next;
        }
        n = new HashNode<>(key, value);
        n.next = chainArray[ind];
        chainArray[ind] = n;
        size++;
    }

    public V get(K key){
        int ind = hash(key);
        HashNode<K, V> n = chainArray[ind];
        while (n != null) {
            if (n.key.equals(key)) {
                return n.value;
            }
            n = n.next;
        }
        return null;
    }

    public V remove(K key){
        int ind = hash(key);
        HashNode<K, V> n = chainArray[ind];
        HashNode<K, V> last = null;
        while (n!= null) {
            if (n.key.equals(key)) {
                if (last == null) {
                    chainArray[ind] = n.next;
                } else {
                    last.next = n.next;
                }
                size--;
                return n.value;
            }
            last = n;
            n = n.next;
        }
        return null;
    }

    public boolean contains(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> n = chainArray[i];
            while (n != null) {
                if (n.value.equals(value)) {
                    return true;
                }
                n = n.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> n = chainArray[i];
            while (n != null) {
                if (n.value.equals(value)) {
                    return n.key;
                }
                n = n.next;
            }
        }
        return null;
    }
}

