public class MyHashTable<K, V> {
    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + ": " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value){
        int hash = hash(key);
        HashNode<K, V> head = chainArray[hash];
        if(head != null){
            if (head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[hash];
        chainArray[hash] = newNode;
        size++;
    }

    public V get(K key){
        HashNode<K, V> head = chainArray[hash(key)];
        while(head != null){
            if(head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public V remove(K key){
        int hash = hash(key);
        HashNode<K, V> head = chainArray[hash];
        HashNode<K, V> prev = null;

        while(head != null){
            if (head.key.equals(key)){
                if (prev != null){
                    prev.next = head.next;
                }
                else {
                    chainArray[hash] = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public boolean contains(V value){
        for (HashNode<K, V> head : chainArray) {
            while (head != null) {
                if (head.value.equals(value))
                    return true;
                head = head.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for (HashNode<K, V> head : chainArray) {
            while (head != null) {
                if (head.value.equals(value))
                    return head.key;
                head = head.next;
            }
        }
        return null;
    }

    public int getNumberOfBuckets(){
        return M;
    }

    public int getBucketSize(int index){
        int size = 0;
        HashNode<K, V> head = chainArray[index];
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
}

