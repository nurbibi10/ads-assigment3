public class MyTestingForBST {
    public static void main(String[] args) {

        BinaryST<Integer, String> bst = new BinaryST<Integer, String>();

        bst.put(7, "nurbibi");
        bst.put(6, "dilyra");
        bst.put(13, "fahima");
        bst.put(14, "aruzhan");
        bst.put(8, "aiganym");

        System.out.println("the size of bst is: "+bst.size());
        System.out.println("value of key 4: "+bst.get(4));
        System.out.println("value of key 1: "+bst.get(1));

        bst.delete(2);
        bst.delete(3);
        System.out.println("size after deletion is: "+bst.size());

        System.out.println("keys in bst in ascending order: ");
        for (Integer key : bst.iterator()) {
            System.out.println(key);
        }

    }
}
