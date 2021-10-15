// converting the Binary Search Tree into Right Skewed Tree
package com.mycompany.GradedProject3;
//Defining a class Node
class Node{
      int value;
      Node left;
      Node right;
   
   // Constructor Node
      Node(int key){
         value = key;
         left = null; // setting the left node as null
         right = null;// setting the right node as null
      }
    
    }
public class BinarySearchTreeSkewedTree {
     
    public static Node node; 
    static Node prevNode = null;
    static Node head = null; // setting the head node as null initially
    
    
    static void binarySearchTreeToSkewed(Node root){
        if (root == null)
            return;
        binarySearchTreeToSkewed(root.left); // recursively calling the function
        Node rightNode = root.right;
        if (head == null){ // to check if the root node is not defined
            head = root;    // if not defined, set the root as the head
            root.left = null;
            prevNode = root;
        }
        else{
            prevNode.right = root;
            root.left = null;
            prevNode =root;
        }
        binarySearchTreeToSkewed(rightNode);// Recursively calling the function with the right node
    }
    
    // Function to traverse the right skewed tree using recursion
    static void traverseRightSkewedTree(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.value + " ");
        traverseRightSkewedTree(root.right);
    
    }
    
    public static void main(String args[]) {
        BinarySearchTreeSkewedTree tree = new BinarySearchTreeSkewedTree();
        // setting each of the nodes with the value
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.left.right = new Node(40);
        tree.node.right= new Node(60);
        tree.node.left.left = new Node(10);
        
        binarySearchTreeToSkewed(node);
        traverseRightSkewedTree(head);
    }
}
