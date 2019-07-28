package offer66;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ListIterator;
import java.util.Stack;

/**
 * @className:DeleteDuplication
 * @author:huanglf714
 * @create:2019/5/22 11:02
 * @decription:
 **/
public class DeleteDuplication {
    /**
     * @author:huanglf714
     * @description:
     * 删除重复节点，不保留重复节点
     * @date:2019/5/22 11:36
     * @param:
     * @return:
    **/
    public static ListNode delete(ListNode pHead){
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        //做一个辅助的头结点
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
            }else{
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head.next;
    }

    /**
     * @author:huanglf714
     * @description:
     * 删除多的重复节点，但是保留其中之一
     * @date:2019/5/22 11:35
     * @param:[pHead]
     * @return:offer66.ListNode
    **/
    public static ListNode delete2(ListNode pHead){
        if(pHead==null){
            return null;
        }
        ListNode pre = pHead;
        ListNode cur = pre.next;
        while(cur!=null&&pre!=null){
            if(pre.val==cur.val){
                cur = cur.next;
            }else{
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }

        }
        return pHead;
    }
    
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+",");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = null;
        print(head);
        print(delete(head));

    }
}
