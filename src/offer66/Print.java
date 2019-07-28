package offer66;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @className:Print
 * @author:huanglf714
 * @create:2019/5/23 16:15
 * @decription:
 **/
public class Print {
    /**
     * @author:huanglf714
     * @description:之字形打印
     * @date:2019/5/23 17:08
     * @param:[pRoot]
     * @return:java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>
    **/
    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot==null){return result;}
        Deque<TreeNode> deque = new LinkedList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(pRoot.val);
        result.add(first);
        boolean isOdd = false;
        int count = 0,amount = 1;
        deque.add(pRoot);
        while(!deque.isEmpty()){
            TreeNode root = deque.poll();
            count++;
            if(root.left!=null){
                deque.offer(root.left);
            }
            if(root.right!=null){
                deque.offer(root.right);
            }
            if(count==amount){
                amount=deque.size();
                if(amount==0){
                    break;
                }
                System.out.println("amount"+amount);
                count = 0;
                ArrayList<Integer> tmp = new ArrayList<>();
                LinkedList<TreeNode> clone = new LinkedList<>(deque);
                if(isOdd){
                    System.out.println("111111111111");
                    result.add(add1(clone));
                    isOdd = false;
                }else{
                    System.out.println("2222222222222");
                    result.add(add2(clone));
                    isOdd = true;
                }

            }
        }
        return result;
    }

    /**
     * @author:huanglf714
     * @description:层次遍历
     * @date:2019/5/23 17:09
     * @param:
     * @return:
    **/
    public static ArrayList<ArrayList<Integer>> print2(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot==null){return result;}
        Deque<TreeNode> deque = new LinkedList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(pRoot.val);
        result.add(first);
        int count = 0,amount = 1;
        deque.add(pRoot);
        while(!deque.isEmpty()) {
            TreeNode root = deque.poll();
            count++;
            if (root.left != null) {
                deque.offer(root.left);
            }
            if (root.right != null) {
                deque.offer(root.right);
            }
            if (count == amount) {
                amount = deque.size();
                if (amount == 0) {
                    break;
                }
                count = 0;
                ArrayList<Integer> tmp = new ArrayList<>();
                LinkedList<TreeNode> clone = new LinkedList<>(deque);
                result.add(add1(clone));
            }
        }
        return result;

    }

    public static ArrayList<Integer> add1(LinkedList<TreeNode> clone){
        ArrayList<Integer> tmp = new ArrayList<>();
        while(!clone.isEmpty()){
            tmp.add(clone.removeFirst().val);
        }
        return tmp;
    }

    public static ArrayList<Integer> add2(LinkedList<TreeNode> clone){
        ArrayList<Integer> tmp = new ArrayList<>();
        while(!clone.isEmpty()){
            tmp.add(clone.removeLast().val);
        }
        return tmp;
    }
    
    public static void main(String[] args){
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(6);
        head.right = new TreeNode(10);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(7);
        head.right.left = new TreeNode(9);
        head.right.right = new TreeNode(11);
        ArrayList<ArrayList<Integer>> reuslt = print2(head);
        for(ArrayList<Integer> tmp:reuslt){
            System.out.println(tmp);
        }
    }
}
