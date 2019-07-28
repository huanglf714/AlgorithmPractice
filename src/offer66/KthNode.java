package offer66;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @className:KthNode
 * @author:huanglf714
 * @create:2019/5/24 10:27
 * @decription:
 * 给定一棵二叉搜索树，
 * 请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8)中，
 * 按结点数值大小顺序第三小结点的值为4。
 **/
public class KthNode {

    /**
     * @author:huanglf714
     * @description:中序遍历的第K个节点,中序遍历递归
     * @date:2019/5/24 11:32
     * @param:[pRoot, k]
     * @return:offer66.TreeNode
    **/
    int index = 0;
    TreeNode find1(TreeNode pRoot, int k)
    {
        if(pRoot!=null){
            TreeNode node = find1(pRoot.left,k);
            index++;
            if(node!=null){
                return node;
            }
            if(index==k){
                return pRoot;
            }
            node = find1(pRoot.right,k);
            if(node!=null){
                return node;
            }
        }
        return null;
    }

    public static TreeNode find2(TreeNode pRoot,int k){
        int count=0;
        Stack<TreeNode> nodeStack = new Stack<>();
        if(pRoot==null||k<=0){
            return null;
        }
        do{
            if(pRoot!=null){
                nodeStack.push(pRoot);
                pRoot = pRoot.left;
            }else{
                pRoot = nodeStack.pop();
                count++;
                if(count==k){
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }while(pRoot!=null||!nodeStack.isEmpty());
        return null;
    }

    public static void main(String[] args){
        
    }
}
