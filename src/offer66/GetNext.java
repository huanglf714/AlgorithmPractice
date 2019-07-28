package offer66;

/**
 * @className:GetNext
 * @author:huanglf714
 * @create:2019/5/23 11:41
 * @decription:
 **/
public class GetNext {
    public TreeLinkNode get(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        //右子树不为空则返回右子树的最左边节点
        if(pNode.right!=null){
            TreeLinkNode righChild = pNode.right;
            while(righChild.left!=null){
                righChild = righChild.left;
            }
            return righChild;
        }
        //右子树为空则返回左子树被遍历结束的父节点
        while(pNode.next!=null){
            TreeLinkNode parent = pNode.next;
            //若当前节点为父节点的左子树，则下一节点就是其父节点
            if(pNode==parent.left){
                return pNode.next;
            }
            //若当前节点为父节点的右子树，则找父节点的父节点，直到是父节点的左子树
            pNode = pNode.next;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
