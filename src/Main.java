public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>(10);
        hashTable.put("daniya", 1);
        hashTable.put("alua", 2);
        hashTable.put("elya", 3);
        System.out.println(hashTable.get("alua"));
        System.out.println(hashTable.contains(3));
        System.out.println(hashTable.contains(4));
        System.out.println(hashTable.getKey(2));
        System.out.println(hashTable.remove("elya"));
        System.out.println(hashTable.get("elya"));
        int[] bucketSizes = hashTable.getBucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + " has " + bucketSizes[i] + " elements.");
        }
    }
}