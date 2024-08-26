/**
 * 反转链表
 *
 * @Author: Xiaov
 * @Date: 2024/8/27 06:12
 */
public class Problem023 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pA = head.next;
        head.next = null;
        while (pA != null) {
            ListNode tmp  = pA;
            pA = pA.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }

    // 递归
    public ListNode reverseListFunc2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseListFunc2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
