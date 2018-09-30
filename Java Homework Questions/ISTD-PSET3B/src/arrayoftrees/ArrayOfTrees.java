package arrayoftrees;

class BinarySearchTree {
    public Node root;
    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(String id){



        Node newNode = new Node(id);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if (id.equals(current.data)) {
                return;
            }
            else {
                if(id.compareTo(current.data) < 0 ) {
                    current = current.left;
                    if(current==null){
                        parent.left = newNode;
                        return;
                    }
                }else{
                    current = current.right;
                    if(current==null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node searchNode(Node node, String s_data)
    {
        if ( node == null ) 
            return null;
        if ( node.data.equals(s_data) ) 
            return node;
        if ( node.data.compareTo(s_data) > 0) {
            return searchNode(node.left, s_data);
        } else {
            return searchNode(node.right, s_data);
        }
    }

    public Node search(String data) {
        String lowerdata = data.toLowerCase();
        Node node = root;
        return searchNode(node, lowerdata);
    }

}

class Node{
    String data;
    int count;
    Node left;
    Node right;
    public Node(String data){
        this.data = data;
        this.count = 1;
        left = null;
        right = null;
    }

    public void incCount() {
        count++;
    }
    public String toString() {
        return String.format("%s(%d)",data, count);
    }
}

public class ArrayOfTrees 
{
    BinarySearchTree [] arr = new BinarySearchTree[26];

    public ArrayOfTrees() {
        for ( int n=0; n < 26; n++ ) {
            arr[n] = new BinarySearchTree();
        }
    }

    public void putWord(String word) {
        int pos = word.toLowerCase().charAt(0) - 'a';    

        if (pos < 0 ||  pos >= 26 ) return;

        BinarySearchTree t = arr[pos];
        Node n = t.search(word);
        if ( n == null ) {
            t.insert(word);
        } else {
            n.incCount();
        }
    }

    public void inOrder(Node root) {
        if ( root != null ) {
            inOrder(root.left);
            System.out.print("" + root);
            inOrder(root.right);
        }
    }

    public void trans() {
        for (int alpha=0; alpha < 26; alpha++ ) {
            BinarySearchTree tr = arr[alpha];
            if ( tr.root != null ) {
                inOrder(tr.root);
                System.out.println();
            }
        }
    }

    public static void main(String [] args) {
        ArrayOfTrees arrtree = new ArrayOfTrees();

        String input = "This is a piece of text from which hopefully you will make some trees.";
        String [] arr = input.split("\\s+");
        for ( int n = 0; n < arr.length ; n++ ) {
            String myword = arr[n];
            arrtree.putWord(myword);
        }
        arrtree.trans();
    }
}