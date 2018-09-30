package TrinarySeachTree;

/**
 * Created by jit_biswas on 10/15/2017.
 */

public class TrinarySearchTree {
    public static  Node root;
    public TrinarySearchTree(){
        this.root = null;
    }

    public void insert(int id){
        //Node newNode = new Node(id);
        if(root==null){
            Node newNode = new Node(id);
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if (id == current.min || id == current.max) {
                return;
            }
            /*
            if ( current.max == -1 ) { //checking max indicate that this node only has min filled
                if ( id > current.min ) {
                    current.max = id;
                } else { //swap
                    current.max = current.min; 
                    current.min = id;
                }
                return;
            } 
            */
            if ( id < current.min ) {
                current = current.left;
                if ( current == null ) {
                    Node newNode = new Node(id);
                    parent.left = newNode;
                    return;
                }
            }
            else if ( current.max == -1 ) { 
                if ( id > current.min ) {
                    current.max = id;
                } else { //swap
                    current.max = current.min; 
                    current.min = id;
                }
                return;
            } 
            else if ( id > current.max ) {
                current = current.right;
                if ( current == null ) {
                    Node newNode = new Node(id);
                    parent.right = newNode;
                    return;
                }
            } else { //middle
                current = current.middle;
                if ( current == null ) {
                    Node newNode = new Node(id);
                    parent.middle = newNode;
                    return;
                }
            }
        }
    }
    
    public int findMin() {
        Node node = root;
        while ( node.left != null ) {
            node = node.left;
        }
        return node.min;
    }

    public int findMax() {
        Node node = root;
        while ( node.right != null ) {
            node = node.right;
        }
        return node.max == -1? node.min: node.max;
    }

    private int searchNode(Node node, int data) {
        if ( node == null ) 
            return -1;
        else  if ( node.min == data || node.max == data ) 
            return data;
        else {
            if ( searchNode(node.left, data) == data )
                return data;
            if ( searchNode(node.middle, data) == data ) 
                return data;
            if ( searchNode(node.right, data) == data ) 
                return data;
            return -1; //not found
        }
    }

    public int search(int data) {
        Node node = root;
        return searchNode(node, data);
    }


    public void preOrder(Node root){
        if(root!=null){
            System.out.print(" " + root.min +" "+ root.max + ":");
            preOrder(root.left);
            preOrder(root.middle);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(" " + root.min +":" );
            inOrder(root.middle);
            System.out.print(" " + root.max +":");
            inOrder(root.right);
        }
    }

    public void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.middle);
            postOrder(root.right);
            System.out.print(" " + root.min +" "+ root.max + ":");
        }
    }

}

class Node{
    int min, max;
    
    Node left;
    Node right;
    Node middle;
    public Node(int data){
        this.min = data;
        this.max = -1;
        left = null;
        right = null;
        middle = null;
    }
}

