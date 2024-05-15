public class MyTestingForBST {
    public static void main(String[] args) {
        BinaryST<Integer, String> bst = new BinaryST<>();

        bst.put(7, "nurbibi");
        bst.put(6, "dilyra");
        bst.put(13, "fahima");
        bst.put(14, "aruzhan");
        bst.put(8, "aiganym");

        System.out.println("The size of BST is: " + bst.size());
        System.out.println("Value of key 4: " + bst.get(4));
        System.out.println("Value of key 1: " + bst.get(1));

        bst.delete(2);
        bst.delete(3);
        System.out.println("Size after deletion is: " + bst.size());

        System.out.println("Keys in BST in ascending order: ");
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }
    }
}