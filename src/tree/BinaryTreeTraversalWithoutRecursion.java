package tree;

import java.util.Stack;

/**
 * @className:BinaryTreeTraversalWithoutRecursion
 * @author:huanglf714
 * @create:2019/5/24 15:46
 * @decription:
 * 二叉树的遍历without递归
 **/
public class BinaryTreeTraversalWithoutRecursion {

    /**
     * @author:huanglf714
     * @description:
     * 先序遍历非递归，用栈保存元素
     * @date:2019/5/24 15:48
     * @param:
     * @return:
    **/
    public static void preOrderWithoutRecursion(TreeNode root){

    }

    /**
     * @author:huanglf714
     * @description:
     * 中序遍历非递归，用栈保存元素+回溯法
     * @date:2019/5/24 15:47
     * @param:[root]
     * @return:void
    **/
    public static void inOrderWithoutRecursion(TreeNode root){
        Stack<TreeNode> nodeStack = new Stack<>();
        do{
            if(root!=null){
                nodeStack.push(root);
                root = root.left;
            }else{
                root = nodeStack.pop();
                System.out.print(root.val+",");
                root = root.right;
            }
        }while(root!=null||!nodeStack.isEmpty());
    }

    /**
     * @author:huanglf714
     * @description:
     * 后序遍历非递归
     * @date:2019/7/28 11:08
     * @param:[root]
     * @return:void
    **/
    public static void postOrderWithoutRecursion(TreeNode root){

    }

    /**
     * @author:huanglf714
     * @description:层次遍历
     * @date:2019/5/24 11:16
     * @param:[root]
     * @return:void
     **/
    public static void levelOrder(TreeNode root){
    }
}
