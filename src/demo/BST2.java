//Java program to create BST shown in figure

package demo;

public class BST2 {
	// Declaring a variable to hold the root node of the binary search tree
    private Node root; 
 // Declaring a variable to hold the size of the binary search tree
    private int size; 
 // Creating a nested Node class to represent each node of the binary search tree
    private static class Node { 
    	// Declaring a variable to hold the value of each node
        int value; 
     // Declaring a variable to hold the left child of each node
        Node left; 
     // Declaring a variable to hold the right child of each node
        Node right; 

     // Constructor to create a new node with the given value
        Node(int value) { 
            this.value = value;
            left = null;
            right = null;
        }
    }
 // Method to add a node with the given value to the binary search tree
    public void add(int value) { 
    	// Call the recursive method addRecursive() to add the node
        root = addRecursive(root, value); 
        size++; // Incrementing the size of the binary search tree
    }
 // Recursive method to add a node with the given value to the binary search tree
    private Node addRecursive(Node current, int value) { 
// If the current node is null, creating a new node with the given value
        if (current == null) { 
            return new Node(value);
        }
// If the value is less than the value of the current node, adding the value to the left subtree
        if (value < current.value) { 
            current.left = addRecursive(current.left, value);
// If the value is greater than the value of the current node, adding the value to the right subtree
        } else if (value > current.value) { 
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists, do nothing
        }

        return current; // Returning the current node
    }
 // Method to return the size of the binary search tree
    public int size() { 
        return size;
    }
 // Main method to test the binary search tree
    public static void main(String[] args) { 
        // creating a binary tree
        BST2 bst = new BST2();

        // add nodes to the binary tree
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

        // checking if all nodes have been added
     // Declaring the expected size of the binary search tree
        int expectedSize = 13; 
     // Getting the actual size of the binary search tree
        int actualSize = bst.size(); 
// If the actual size is equal to the expected size, printing a message indicating that all nodes have been added
        if (expectedSize == actualSize) { 
            System.out.println("All nodes have been added to the binary tree.");
// If the actual size is not equal to the expected size, printing a message indicating that not all nodes have been added
        } else { 
            System.out.println("Not all nodes have been added to the binary tree.");
        }
    }
}
