package tree;


import static tree.BinaryTreeTraversal.*;
import static tree.BinaryTreeTraversalWithoutRecursion.*;

/**
 * @className:BinaryTraversalTest
 * @author:huanglf714
 * @create:2019/5/24 15:49
 * @decription:
 **/
public class BinaryTraversalTest {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("preOrder:  ");
        preOrder(root);
        System.out.println();
        System.out.println("inOrder:  ");
        inOrder(root);
        System.out.println();
        System.out.println("postOrder:  ");
        postOrder(root);
        System.out.println();
        System.out.println("preOrderWithoutRecursion:  ");
        preOrderWithoutRecursion(root);
        System.out.println();
        System.out.println("inOrderWithoutRecursion:  ");
        inOrderWithoutRecursion(root);
        System.out.println();
        System.out.println("postOrderWithoutRecursion:  ");
        postOrderWithoutRecursion(root);
        System.out.println();
        System.out.println("levelOrder:  ");
        levelOrder(root);
        System.out.println();
    }
}
