public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(15);
        bst.add(7);
        bst.add(18);
        bst.add(16);
        bst.add(19);
        bst.add(12);
        bst.add(6);

        bst.inorder(bst.root);

        System.out.println();

        bst.preorder(bst.root);

        System.out.println();

        bst.postorder(bst.root);

        System.out.println();

        bst.levelOrder(bst.root);

        System.out.println();

        bst.deleteKey(15);

        bst.levelOrder(bst.root);

    }


}
