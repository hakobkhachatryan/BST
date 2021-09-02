import java.util.LinkedList;
import java.util.Queue;

public class BST{
    Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }
    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }

    //recursive delete function
    Node delete_Recursive(Node root, int key)  {
        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = delete_Recursive(root.left, key);
        }
        else if (key > root.value) {
            root.right = delete_Recursive(root.right, key);
        }
        else  {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = delete_Recursive(root.right, root.value);
        }
        return root;
    }

    int minValue(Node root)  {
        int minvalue = root.value;

        while (root.left != null)  {
            minvalue = root.left.value;
            root = root.left;
        }
        return minvalue;
    }







    void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.value + ", ");
        inorder(root.right);
    }

    void preorder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.value + ", ");
        preorder(root.left);
        preorder(root.right);
    }

    void postorder(Node root){
        if (root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + ", ");
    }

    void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value + " ");


            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

}

class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}