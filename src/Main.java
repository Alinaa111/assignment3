public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass o = MyTestingClass.generateRandomData();
            table.put(o, new Student(i, "Student" + i, 18 + (i % 10), i % 101));
        }

        printCountsOfBucket(table);


        BST<Integer, String> bst = new BST<>();
        bst.put(1, "Student1");
        bst.put(2, "Student2");
        bst.put(3, "Student3");

        for (var elem : bst) {
            System.out.println("key: " + elem.getKey() + ", value: " + elem.getVal());
        }
    }

    public static void printCountsOfBucket(MyHashTable<MyTestingClass, Student> table){
        for (int i = 0; i < table.getNumberOfBuckets(); i++) {
            System.out.println("Bucket " + i + ": " + table.getBucketSize(i) + " elements");
        }
    }
}