import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

// Java program for different tree traversals 
  
/* Class containing left and right child of current 
   node and key value*/
class Node 
{ 
    String key; 
    Node left, right; 
  
    public Node(String item) 
    { 
        key = item; 
        left = right = null; 
    } 
} 
  
class BinaryTree 
{ 
    // Root of Binary Tree 
    Node root; 
  
    BinaryTree() 
    { 
        root = null; 
    } 
  
    /* Given a binary tree, print its nodes according to the 
      "bottom-up" postorder traversal. */
    void printPostorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostorder(node.left); 
  
        // then recur on right subtree 
        printPostorder(node.right); 
  
        // now deal with the node 
        System.out.print(node.key + " "); 
    } 
  
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.key + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 
  
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first print data of node */
        System.out.print(node.key + " "); 
  
        /* then recur on left sutree */
        printPreorder(node.left); 
  
        /* now recur on right subtree */
        printPreorder(node.right); 
    } 
    
    
  
    // Wrappers over above recursive functions 
    void printPostorder()  {     printPostorder(root);  } 
    void printInorder()    {     printInorder(root);   } 
    void printPreorder()   {     printPreorder(root);  } 
    
  
    // Driver method 
    public static void main(String[] args) 
    { 
        BinaryTree tree = new BinaryTree();
        Scanner scan = new Scanner(System.in);
        tree.root = new Node("b"); 
        tree.root.left = new Node("a"); 
        tree.root.right = new Node("c");
        ArrayList<String> str=new ArrayList<String>();  
       for(int i=0 ; i<100 ; i++) {
    	   str.add(scan.nextLine());
    	   if(str.get(i).length()==0) {
    		   str.remove(i);
    		   break;
    	   }
       }
       for(int k=0 ; k<str.size(); k=k+2) 
       {
    	   String[] word2 = str.get(k+1).split("");
    	   String[] word = str.get(k).split("");
		   System.out.println(" "+word2[0]+" ");
    	   if(word2[1] == word[0]) {
    		   System.out.println(word2[1]+" ");
    	   }
    	   
       }
           
       
  
      /*  System.out.println("Preorder traversal of binary tree is "); 
        tree.printPreorder(); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.printInorder(); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.printPostorder(); */
    } 
} 