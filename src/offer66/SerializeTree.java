package offer66;

import java.io.Serializable;

/**
 * @className:SerializeTree
 * @author:huanglf714
 * @create:2019/5/24 9:06
 * @decription:
 **/
public class SerializeTree {

    static StringBuilder strBuilder = new StringBuilder();
    static String Serialize(TreeNode root) {
        if(root==null){
            strBuilder.append("#,");
        }else{
            strBuilder.append(root.val+",");
            String s1 = Serialize(root.left);
            String s2 = Serialize(root.right);
        }
        return strBuilder.toString();
    }

    static int index = -1;
    static TreeNode Deserialize(String str) {
        index++;
        if(str==null||str.length()<=index){
            return null;
        }
        String[] strings = str.split(",");
        String cur = strings[index];
        TreeNode node = null;
        if(!cur.equals("#")){
            node = new TreeNode(Integer.parseInt(cur));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

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
        String str = Serialize(root);
        System.out.println(str+"***********");
        TreeNode root2 = Deserialize(str);
        System.out.println("-----------------");
        System.out.println(Serialize(root2)+"*******************");
    }
}
