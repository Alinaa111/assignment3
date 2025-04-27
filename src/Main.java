public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass o = MyTestingClass.generateRandomData();
            table.put(o, new Student(i, "Student" + i, 18 + (i % 10), i % 101));
        }

        printCountsOfBucket(table);

    }

    public static void printCountsOfBucket(MyHashTable<MyTestingClass, Student> table){
        for (int i = 0; i < table.getNumberOfBuckets(); i++) {
            System.out.println("Bucket " + i + ": " + table.getBucketSize(i) + " elements");
        }
    }
}