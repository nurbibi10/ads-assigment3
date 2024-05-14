public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> hashTable = new MyHashTable<>();

        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(3, "Three");

        System.out.println("Value for key 1: " + hashTable.get(1));
        System.out.println("Removed value: " + hashTable.remove(3));
        System.out.println("Contains 'Three': " + hashTable.contains("Three"));
        System.out.println("Key for value 'One': " + hashTable.getKey("One"));
    }
}