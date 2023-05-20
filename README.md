## Assignment4
# MyHashTable
MyHashTable is a simple implementation of a hash table data structure. It's designed to store key-value pairs, where the keys are instances of the `MyTestingClass` class and the values are instances of the `Student` class.

## Usage
To use the MyHashTable class, simply create a new instance of it with an initial capacity, like so:

```
MyHashTable<MyTestingClass, Student> hashTable = new MyHashTable<>(10);
```
You can then use the `put()`, `get()`, `contains()`, `getKey()`, and `remove()` methods to interact with the hash table, like so:

```
hashTable.put(key, value);
Student student = hashTable.get(key);
boolean contains = hashTable.contains(value);
MyTestingClass key = hashTable.getKey(value);
Student removed = hashTable.remove(key);
``` 

Additionally, you can use the `getBucketSizes()` method to get an array of the sizes of each bucket in the hash table, like so:
```
int[] bucketSizes = hashTable.getBucketSizes();
```

## MyTestingClass
The MyTestingClass class is a simple class that represents a key in the hash table. It contains three fields: `x`, `y`, and `z`. The `hashCode()` method is overridden to provide a custom hash code for each instance based on the values of these fields.
Also, demonstrates how to use the MyHashTable class. It contains three methods:

`put10000()`: puts 10,000 randomly generated key-value pairs into the hash table

`putTest()`: puts three key-value pairs into the hash table and performs various operations on them

`bucketTest()`: prints out the sizes of each bucket in the hash table 

## Student
The Student class is a simple class that represents a value in the hash table. It contains three fields: `name`, `group`, and `gpa`.
