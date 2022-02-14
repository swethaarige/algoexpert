import java.util.List;

/*
Algorithm Inorder(tree)
   1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   2. Visit the root.
   3. Traverse the right subtree, i.e., call Inorder(right-subtree)
Algorithm Preorder(tree)
   1. Visit the root.
   2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   3. Traverse the right subtree, i.e., call Preorder(right-subtree)
Algorithm Postorder(tree)
   1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   3. Visit the root.
 */

public class BSTTraversal {
    static class BST {
        public int value;
        public BST left;
        public BST right;
        public BST(int value) {
            this.value = value;
        }
    }
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }
        return array;
    }
    public static List<Integer> preOrderTraversal(BST tree, List<Integer> array) {
        array.add(tree.value);
        if (tree.left != null) {
            preOrderTraversal(tree.left, array);
        }
        if (tree.right != null) {
            preOrderTraversal(tree.right, array);
        }
        return array;
    }
    public static List<Integer> postOrderTraversal(BST tree, List<Integer> array) {
       if(tree.left != null) {
           postOrderTraversal(tree.left, array);
       }
       if (tree.right != null) {
           postOrderTraversal(tree.right, array);
       }
       array.add(tree.value);
        return array;
    }
}
