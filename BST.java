//Java program to create a BST by adding 56 and then adding 30 & 70

package demo;

public class BST<K extends Comparable<K>> {
    
// Defining an interface for a binary tree node that has a key value and left and right child nodes
    interface INode<K> {
        K getKey();
        void setKey(K key);
        INode<K> getLeft();
        void setLeft(INode<K> left);
        INode<K> getRight();
        void setRight(INode<K> right);
    }
    
// Defining a concrete implementation of the binary tree node interface
    public static class MyBinaryNode<K extends Comparable<K>> implements INode<K> {
        private K key;
        private INode<K> left;
        private INode<K> right;
        
// Constructor that takes a key value and sets the left and right child nodes to null
        public MyBinaryNode(K key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
        
// Getters and setters for the key value, left child node, and right child node
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public INode<K> getLeft() {
            return left;
        }

        @Override
        public void setLeft(INode<K> left) {
            this.left = left;
        }

        @Override
        public INode<K> getRight() {
            return right;
        }

        @Override
        public void setRight(INode<K> right) {
            this.right = right;
        }
    }
    
    private INode<K> root; // The root of the binary search tree
    
    // Constructor that sets the root to null
    public BST() {
        root = null;
    }
    
    // Method to add a key to the binary search tree
    public void add(K key) {
        root = addRecursively(root, key); // Call the recursive add method starting from the root node
    }
    
    // Recursive method to add a key to the binary search tree
    private INode<K> addRecursively(INode<K> current, K key) {
 // If the current node is null, create a new node with the key value
        if (current == null) { 
            return new MyBinaryNode<>(key);
        }
// If the key value is less than the current node's key value, add it to the left child node
        if (key.compareTo(current.getKey()) < 0) { 
            current.setLeft(addRecursively(current.getLeft(), key));
// If the key value is greater than the current node's key value, add it to the right child node
        } else if (key.compareTo(current.getKey()) > 0) { 
            current.setRight(addRecursively(current.getRight(), key));
        }
        
        return current; // Return the current node
    }
    
    // Method to perform an in-order traversal of the binary search tree
    public void inOrderTraversal() {
// Call the recursive in-order traversal method starting from the root node
        inOrderTraversalRecursively(root); 
    }
    
// Recursive method to perform an in-order traversal of the binary search tree
    private void inOrderTraversalRecursively(INode<K> current) {
// If the current node is not null, traverse the left child node, visit the current node, and then traverse the right child node
        if (current != null) { 
            inOrderTraversalRecursively(current.getLeft());
            System.out.print(current.getKey() + " ");
            inOrderTraversalRecursively(current.getRight());
        }
    }
 // Defining a main method for testing the binary search tree
    public static void main(String[] args) {
    	 // Create a new binary search tree and add some keys 
        BST<Integer> bst = new BST<>();
        bst.add(56);
        bst.add(30);
        bst.add(70);
        bst.inOrderTraversal(); // output: 30 56 70
    }
}
