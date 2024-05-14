import java.util.Random;

public class MyTestingClass {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> nabi = new MyHashTable<>();

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            nabi.put(new MyTestingClass(RandomString.randomString(7), random.nextInt(10000)),
                    random.nextInt(10000));
        }


    }
}
