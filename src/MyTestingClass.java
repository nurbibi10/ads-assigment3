import java.util.Objects;
import java.util.Random;

class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return id == that.id && Objects.equals(name, that.name);
    }
}

class MyTestingForHashTable {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>(11);
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(10000);
            String name = "Name" + random.nextInt(10000);
            MyTestingClass key = new MyTestingClass(id, name);
            table.put(key, "Value" + i);
        }

        // Print the number of elements in each bucket
        for (int i = 0; i < table.chainArray.length; i++) {
            int count = 0;
            MyHashTable<MyTestingClass, String>.HashNode<MyTestingClass, String> node = table.chainArray[i];
            while (node != null) {
                count++;
                node = node.getNext();
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}