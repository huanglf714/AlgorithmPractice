package offer66;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @className:TreeDepth
 * @auther:huanglf714
 * @create:2019/5/17 14:47
 * @decription:
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 **/
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}
public class TreeDepth {

    /**
     * @author:huanglf714
     * @description:方法一：递归算法
     * @date:2019/5/17 14:52
     * @param:[root]
     * @return:int
    **/
    public static int depth1(TreeNode root){
        if(root==null){
            return 0;
        }
        else{
            return Math.max(depth1(root.left),depth1(root.right))+1;
        }
    }

    /**
     * @author:huanglf714
     * @description:方法二：非递归写法：层次遍历
     * 但是要注意同一层不要重复计算层数
     * @date:2019/5/17 14:53
     * @param:[root]
     * @return:int
    **/
    public static int  depth2(TreeNode root){
        int count = 0,nextCount=1,depth = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            count++;
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
            //重点步骤
            if(count==nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }
}
