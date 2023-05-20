public class MyHashTable<K, V> {
    // Inner class to represent each node in the hash table
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // Override toString() method to print the node in a readable format
        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray; // The array of nodes, also called buckets
    private int M = 11; // The default size of the array
    private int size; // The number of key-value pairs in the hash table

    // Constructor for the hash table with default size
    public MyHashTable() {
        this.chainArray = new HashNode[M];
        this.size = 0;
    }

    // Constructor for the hash table with specified size
    public MyHashTable(int M) {
        this.chainArray = new HashNode[M];
        this.size = 0;
        this.M = M;
    }

    /**
     * @param key the key for which the bucket index needs to be calculated
     * @return the index of the bucket in which the key-value pair will be stored
     * @hash() this method calculates the index of the bucket in which the key-value pair
     * will be stored based on the hash code of the key and the size of the hash table
     */
    private int hash(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % M;
        // Ensuring that the index is always non-negative
        if (index < 0) {
            index += M;
        }
        return index;
    }

    /**
     * @param key   the key to be inserted
     * @param value the value to be associated with the key
     * @put() inserts the specified key-value pair into the hash map. If the key already exists
     * in the map, its corresponding value is updated with the new value
     */
    public void put(K key, V value) {
        // Calculate the index of the bucket using the hash code of the key
        int index = hash(key);
        // Traverse the linked list in the bucket to find the node with the same key
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                // If the key already exists, update its value and return
                node.value = value;
                return;
            }
            node = node.next;
        }
        // If the key is not found, create a new node and insert it at the beginning of the linked list
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    /**
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this hash table
     * contains no mapping for the key
     * @get() returns the value associated with the specified key in this hash table
     */
    public V get(K key) {
        // Compute the hash code of the key to get the index of the bucket in the hash table
        int index = hash(key);
        // Traverse the linked list in the bucket to find the node with the matching key
        HashNode<K, V> node = chainArray[index];
        while (node != null) {
            if (node.key.equals(key)) {
                // If a matching key is found, return the associated value
                return node.value;
            }
            node = node.next;
        }
        // If the key is not found in the hash table, return null
        return null;
    }

    /**
     * @param key the key to remove from the hash table
     * @return the value associated with the key, or null if the key is not found
     * @remove() removes the key-value pair associated with the specified key
     */
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> prev = null;
        HashNode<K, V> curr = chainArray[index];
        // Traverse the linked list at the given index
        while (curr != null) {
            // If we find the node with the given key
            if (curr.key.equals(key)) {
                // Remove the node from the linked list
                if (prev == null) {
                    chainArray[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                // Decrement the size of the hash table
                size--;
                // Return the associated value
                return curr.value;
            }
            // Move to the next node in the linked list
            prev = curr;
            curr = curr.next;
        }
        // If the key was not found, return null
        return null;
    }

    /**
     * @param value the value to search for in the hash table
     * @return true if the hash table contains the specified value, false otherwise
     * @contains() returns true if this hash table contains the specified value
     */
    public boolean contains(V value) {
        // Iterate over each chain in the hash table
        for (int i = 0; i < chainArray.length; i++) {
            HashNode<K, V> node = chainArray[i];
            // Iterate over each node in the current chain
            while (node != null) {
                // Check if the current node's value matches the specified value
                if (node.value.equals(value)) {
                    return true;
                }
                node = node.next;
            }
        }
        // The value was not found in the hash table
        return false;
    }

    /**
     * @param value the value to search for in the hash table
     * @return the key associated with the value, or null if the value is not found
     * @getKey() returns the key associated with the specified value in the hash table, or null if the value
     * is not found
     */
    public K getKey(V value) {
        // Iterate over each chain in the hash table
        for (int i = 0; i < chainArray.length; i++) {
            HashNode<K, V> node = chainArray[i];
            // Iterate over each node in the current chain
            while (node != null) {
                // Check if the current node's value matches the specified value
                if (node.value.equals(value)) {
                    return node.key;
                }
                node = node.next;
            }
        }
        // The value wasn't found in the hash table
        return null;
    }

    /**
     * @return an array containing the number of elements in each bucket of the hash table
     * @getBucketSizes returns an array containing the number of elements in each bucket of the hash table
     * The size of the array is equal to the number of buckets in the hash table.
     */
    public int[] getBucketSizes() {
        int[] bucketSizes = new int[M];
        // Iterate over each bucket in the hash table
        for (int i = 0; i < M; i++) {
            int size = 0;
            HashNode<K, V> current = chainArray[i];
            // Iterate over each node in the current bucket
            while (current != null) {
                size++;
                current = current.next;
            }
            bucketSizes[i] = size;
        }
        return bucketSizes;
    }

    public void update_record(V oldValue, V newValue) {
        if (contains(oldValue)) {
            K key = getKey(oldValue);
            if (get(key).equals(oldValue)) {
                remove(key);
                put(key, newValue);

            }
        }
    }
}