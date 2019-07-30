package leetcode;


/**
 * @className:Problem5
 * @author:huanglf714
 * @create:2019/7/30 11:07
 * @decription:翻转单链表
 *
 **/
public class Problem5 {
    /**
     * @author:huanglf714
     * @description:方法一：迭代
     * 记住每一个节点的前驱节点，将next指针指向前驱节点
     * @date:2019/7/30 11:09
     * @param:[head]
     * @return:leetcode.ListNode
    **/
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode tmp = curr.next;
            curr.next = previous;
            previous = curr;
            curr = tmp;
        }
        return previous;
    }




}
