package tree;


/**
 * @className:BinaryTreeTraversal
 * @author:huanglf714
 * @create:2019/5/24 15:41
 * @decription:
 * 二叉树的遍历with递归方法
 **/
public class BinaryTreeTraversal {
    /**
     * @author:huanglf714
     * @description:先序遍历
     * @date:2019/5/24 11:10
     * @param:[root]
     * @return:void
     **/
    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.val+",");
            preOrder(root.left);
            preOrder(root.right);
        }

    }
    /**
     * @author:huanglf714
     * @description:中序遍历
     * @date:2019/5/24 11:11
     * @param:[root]
     * @return:void
     **/
    public static void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+",");
            inOrder(root.right);
        }
    }

    /**
     * @author:huanglf714
     * @description:后序遍历
     * @date:2019/5/24 11:12
     * @param:[root]
     * @return:void
     **/
    public static void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+",");
        }
    }

}
