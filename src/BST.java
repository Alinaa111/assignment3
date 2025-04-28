import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K,V>> {
    private Node root;
    private int size = 0;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    public static class Entry<K, V>{
        private final K key;
        private final V val;

        public Entry(K key, V val){
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getVal() {
            return val;
        }
    }

    public void put(K key, V val){
        if (root == null){
            root = new Node(key, val);
            size++;
            return;
        }

        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0){
                if (current.left == null){
                    current.left = new Node(key, val);
                    size++;
                    return;
                }
                current = current.left;
            }
            else if (cmp > 0){
                if (current.right == null){
                    current.right = new Node(key, val);
                    size++;
                    return;
                }
                current = current.right;
            }
            else {
                current.val = val;
                return;
            }
        }
    }

    public V get(K key){
        Node current = root;
        while (current != null){
            int cmp = key.compareTo(current.key);
            if (cmp < 0){
                current = current.left;
            }
            else if (cmp > 0){
                current = current.right;
            }
            else {
                return current.val;
            }
        }
        return null;
    }

    public void delete(K key){
        root = delete(root, key);
        size--;
    }

    private Node delete(Node root, K key){
        Node parent = null;
        Node current = root;

        while (current != null && current.key.compareTo(key) != 0){
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0){
                current = current.left;
            }
            else {
                current = current.right;
            }
        }

        if (current == null) return root;

        if (current.left == null){
            if (parent == null){
                return current.right;
            }
            if (parent.left == current){
                parent.left = current.right;
            }
            else {
                parent.right = current.right;
            }
        }
        else if (current.right == null) {
            if (parent == null) {
                return current.left;
            }
            if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        else{
            Node successorParent = current;
            Node successor = current.right;

            while (successor.left != null){
                successorParent = successor;
                successor = successor.left;
            }

            current.key = successor.key;
            current.val = successor.val;

            if (successorParent.left == current){
                successorParent.left = successor.right;
            }
            else{
                successorParent.right = successor.right;
            }
        }
        return root;
    }

    public Iterator<Entry<K, V>> iterator(){
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<Entry<K, V>>{
        private Stack<Node> stack = new Stack<>();

        public BSTIterator(){
            pushLeft(root);
        }

        private void pushLeft(Node node){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext(){
            return !stack.isEmpty();
        }

        @Override
        public Entry<K, V> next(){
            if (!hasNext()) throw new NoSuchElementException();
            Node current = stack.pop();
            Entry<K, V> entry = new Entry<>(current.key, current.val);
            if (current.right != null){
                pushLeft(current.right);
            }
            return entry;
        }
    }

    public int size(){
        return size;
    }
}
