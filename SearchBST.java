//Java program to search 63 in BST

package demo;

public class SearchBST {
    private Node root;

    // A private nested class representing a node in the binary search tree
    private static class Node {
        int value;
        Node left;
        Node right;

        // Constructor for creating a new node with the given value
        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    // Add a new value to the binary search tree
    public void add(int value) {
        root = addRecursive(root, value);
    }

    // A private helper method for recursively adding a value to the binary search tree
    private Node addRecursive(Node current, int value) {
        // If the current node is null, create a new node with the given value
        if (current == null) {
            return new Node(value);
        }

        // If the value is less than the current node's value, recursively add it to the left subtree
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } 
        // If the value is greater than the current node's value, recursively add it to the right subtree
        else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } 
        // If the value is equal to the current node's value, it already exists in the tree and nothing needs to be done
        else {
            // value already exists
        }

        // Return the current node
        return current;
    }

    // Search for a value in the binary search tree
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    // A private helper method for recursively searching for a value in the binary search tree
    private boolean searchRecursive(Node current, int value) {
        // If the current node is null, the value is not in the tree
        if (current == null) {
            return false;
        }

        // If the current node's value is equal to the value being searched for, return true
        if (current.value == value) {
            return true;
        } 
        // If the value being searched for is less than the current node's value, recursively search the left subtree
        else if (value < current.value) {
            return searchRecursive(current.left, value);
        } 
        // If the value being searched for is greater than the current node's value, recursively search the right subtree
        else {
            return searchRecursive(current.right, value);
        }
    }

    public static void main(String[] args) {
        SearchBST bst = new SearchBST();
        bst.add(56);
        bst.add(30);
        bst.add(70);
        bst.add(22);
        bst.add(40);
        bst.add(60);
        bst.add(95);
        bst.add(11);
        bst.add(65);
        bst.add(3);
        bst.add(16);
        bst.add(63);
        bst.add(67);

        int valueToSearch = 63;
        if (bst.search(valueToSearch)) {
            System.out.println("Value " + valueToSearch + " was found in the tree.");
        } else {
            System.out.println("Value " + valueToSearch + " was not found in the tree.");
        }
    }
}
