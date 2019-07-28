package offer66;

import java.util.Stack;

/**
 * @className:FindFirstCommonNode
 * @auther:huanglf714
 * @create:2019/5/17 10:11
 * @decription:
 **/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    @Override
    public String toString(){
        if(this!=null){
            return String.valueOf(val);
        }else{
            return "null";
        }
    }
}
public class FindFirstCommonNode {

    /**
     * @author:huanglf714
     * @description:
     * 方法一：比较链表的长度，差值为len，将较长的链表从第len个节点开始
     * 较短的链表从第一个节点开始同时遍历，找到第一个相同的结点则为公共节点
     * 运行时间：39ms
     * 占用内存：9524K
     * @date:2019/5/17 10:32
     * @param:[pHead1, pHead2]
     * @return:offer66.ListNode
    **/
    public static ListNode method1(ListNode pHead1, ListNode pHead2) {
        ListNode pPoint1 = pHead1,pPoint2 = pHead2;
        int len1 = 0,len2 = 0;
        while(pPoint1!=null){
            len1++;
            pPoint1 = pPoint1.next;
        }
        while(pPoint2!=null){
            len2++;
            pPoint2 = pPoint2.next;
        }
        if(len1>len2){
            pPoint1 = pHead1;
            pPoint2 = pHead2;
        }else{
            pPoint1 = pHead2;
            pPoint2 = pHead1;
        }
        for(int i=0;i<Math.abs(len1-len2);i++){
            pPoint1 = pPoint1.next;
        }
        while(pPoint1!=null&&pPoint2!=null){
            System.out.println(pPoint1.val+","+pPoint2.val);
            if(pPoint1.val==pPoint2.val){
                return pPoint1;
            }else{
                pPoint1 = pPoint1.next;
                pPoint2 = pPoint2.next;
            }
        }
        return null;
    }

    /**
     * @author:huanglf714
     * @description:
     * 方法二：用两个栈分别保存链表一和链表二的结点，然后依次出栈，
     * 第一个不相同的结点的后续节点为第一个公共节点
     * 运行时间:22ms
     * 占用内存：9484K
     * @date:2019/5/17 11:04
     * @param:[pHead1, pHead2]
     * @return:offer66.ListNode
    **/
    public static ListNode method2(ListNode pHead1, ListNode pHead2){
        if(pHead1==null||pHead2==null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(pHead1!=null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2!=null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode pre = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()
                && stack1.peek().val == stack2.peek().val){
            pre = stack1.pop();
            stack2.pop();
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode pHead1 = new ListNode(1);
        pHead1.next = new ListNode(2);
        pHead1.next.next = new ListNode(3);
        pHead1.next.next.next = new ListNode(4);
        pHead1.next.next.next.next = null;
        ListNode pHead2 = new ListNode(5);
        pHead2.next = new ListNode(6);
        pHead2.next.next = new ListNode(7);
        pHead2.next.next.next = null;
        System.out.println(method2(pHead1,pHead2));
    }
}
