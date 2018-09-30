package TrinarySeachTree;

public class MyClassT {

    public static void main(String[] args) {
        int[] num = {100, 200, 590, 70, 80, 360, 110};

        TrinarySearchTree tr = new TrinarySearchTree();

        for (int i = 0; i < num.length; i++) {
            tr.insert(num[i]);
        }
        System.out.println("\nPreOrder Traversal: ");
        tr.preOrder(tr.root);
        System.out.println("\nInOrder Traversal: ");
        tr.inOrder(tr.root);
        System.out.println("\nPostOrder Traversal: ");
        tr.postOrder(tr.root);
        System.out.println("\nmin = " + tr.findMin());
        System.out.println("\nmax = " + tr.findMax());
        System.out.println("search(200) = " + tr.search(200));
        System.out.println("search(100) = " + tr.search(100));
        System.out.println("search(33) = " + tr.search(33));
        System.out.println("search(63) = " + tr.search(63));
        System.out.println("search(590) = " + tr.search(590));

    }

}
/*
Binary tree traversal vs TrinarySearchTree Traversal Order
Only InOrder traversal is same as TrinarySearchtree's , this may be because each node is paired up, as well as the fact that there is a middle branch
which Post order and preorder traversal steps will lead to a different order.
*/