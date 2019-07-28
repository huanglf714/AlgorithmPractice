package offer66;

/**
 * @className:EntryNodeOfLoop
 * @author:huanglf714
 * @create:2019/5/22 10:03
 * @decription:
 **/
public class EntryNodeOfLoop {
    /**
     * @author:huanglf714
     * @description:
     * 快慢指针+画图推算
     * @date:2019/5/22 11:01
     * @param:[pHead]
     * @return:offer66.ListNode
    **/
    public static ListNode search(ListNode pHead){
        if(pHead==null||pHead.next==null||pHead.next.next==null){
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        //先判断是否有环
        while(fast!=slow){
            if(fast==null||fast.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //若从循环出来，则表示快慢指针相遇一定有环，现在来寻找环的入口节点
        fast = pHead;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
