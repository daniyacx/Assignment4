import java.util.Objects;
import java.util.Random;

public class MyTestingClass {
    MyHashTable hashTable = new MyHashTable<>(10);
    private int x;
    private float y;
    private String z;
    public MyTestingClass(int x, float y, String z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = hash * 5 + x;
        hash = hash * 7 + (int) y;

        char[] letters = z.toCharArray();
        int a = 0;
        for (char i : letters) a = i + (31 * a);

        hash = hash * 13 + a;
        return hash;
    }

    Random random = new Random();

    public void put10000() {
        for (int i = 0; i < 10000; i++) {
            int group = random.nextInt(5000);
            float gpa = random.nextFloat()* 2 + 2;
            String name = String.valueOf(random.nextInt(50000));
            MyTestingClass Key = new MyTestingClass(group, gpa, name);
            Student newbie = new Student("Student " + i, group, gpa);
            hashTable.put(Key, newbie);
        }
    }
    public void putTest() {
        hashTable.put(1, "daniya");
        hashTable.put(2, "alua");
        hashTable.put(3, "elya");
        System.out.println(hashTable.get(2));
        System.out.println(hashTable.contains("elya"));
        System.out.println(hashTable.contains("ruslan"));
        System.out.println(hashTable.getKey("alua"));
        System.out.println(hashTable.remove(3));
        System.out.println(hashTable.get(3));
    }
    public void bucketTest() {
        int[] bucketSizes = hashTable.getBucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + " has " + bucketSizes[i] + " elements.");
        }
    }
}