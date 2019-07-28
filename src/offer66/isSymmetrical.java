package offer66;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @className:isSymmetrical
 * @author:huanglf714
 * @create:2019/5/23 14:42
 * @decription:
 **/
public class isSymmetrical {
    public static boolean judge(TreeNode pRoot){
        if(pRoot==null){
            return false;
        }
        Deque<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(pRoot.left);
        treeNodeQueue.offer(pRoot.right);
        while(!treeNodeQueue.isEmpty()){
            TreeNode left = treeNodeQueue.poll();
            TreeNode right = treeNodeQueue.poll();
            if(left==null&&right==null) {
                continue;
            }
            if(left==null||right==null){
                return false;
            }
            if(left.val!=right.val){
                return false;
            }
            treeNodeQueue.offer(left.left);
            treeNodeQueue.offer(right.right);
            treeNodeQueue.offer(left.right);
            treeNodeQueue.offer(right.left);
        }
        return true;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(judge(root));
    }

}
