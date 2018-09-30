package libbinarysearchtree;

public class MyClass {

    public static void main(String[] args) {
        String S = "100, 200, 590, 70, 80, 360, 110";
        //String S = "SUTD ISTD ASD ESD EPD";

        char[] c1 = S.toCharArray();

        BinarySearchTree b = new BinarySearchTree();

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == ' ') {} else { b.insert(c1[i]);}
        }
        System.out.println("\nPreOrder Traversal: ");
        b.preOrder(b.root);
        System.out.println("\nInOrder Traversal: ");
        b.inOrder(b.root);
        System.out.println("\nPostOrder Traversal: ");
        b.postOrder(b.root);
    }

    public static void compressInput(int[] c1, int[] c2) {
        int p = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == ' ') {
                // do nothing
            } else {
                c2[p] = c1[i];
                p++;
            }
        }
    }
}

