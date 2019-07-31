package leetcode;

/**
 * @className:Problem9
 * @author:huanglf714
 * @create:2019/7/30 18:36
 * @decription:将二叉搜索树转换成累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 解题思路：逆中序，保存之前遍历到的数之和累加到当前节点上
 **/
public class Problem9 {
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            dfs(root,0);
        }
        return root;

    }

    private int dfs(TreeNode node,int sum){
        if(node==null){
            return sum;
        }
        sum = dfs(node.right,sum);
        int tmp = node.val;
        node.val += sum;
        sum += tmp;
        sum = dfs(node.left,sum);
        return sum;
    }
}
