package leetcode;

/**
 * @className:Problem8
 * @author:huanglf714
 * @create:2019/7/30 13:20
 * @decription:合并两个有序列表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 **/
public class Problem8 {
    /**
     * @author:huanglf714
     * @description:迭代解法
     * @date:2019/7/30 13:23
     * @param:[l1, l2]
     * @return:leetcode.ListNode
    **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while(l1!=null&&l2!=null){
            ListNode tmp;
            if(l1.val<=l2.val){
                tmp = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                tmp = new ListNode(l2.val);
                l2 = l2.next;
            }
            point.next = tmp;
            point = point.next;
        }
        if(l1!=null){
            point.next = l1;
        }else{
            point.next = l2;
        }
        return head.next;
    }

    /**
     * @author:huanglf714
     * @description:递归解法
     * @date:2019/7/30 13:23
     * @param:[l1, l2]
     * @return:leetcode.ListNode
    **/
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}
