import java.util.Stack;

public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val){
        if (root == null){
            root = new Node(key, val);
            return;
        }

        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0){
                if (current.left == null){
                    current.left = new Node(key, val);
                    return;
                }
                current = current.left;
            }
            else if (cmp > 0){
                if (current.right == null){
                    current.right = new Node(key, val);
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

    public Iterable<K> iterator(){
        Stack<Node> stack = new Stack<>();
        Stack<K> keys = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            keys.push(current.key);
            current = current.right;
        }

        return keys;
    }
}
