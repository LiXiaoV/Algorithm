/**
 * 删除链表的倒数第 N 个结点
 *
 * @Author: Xiaov
 * @Date: 2024/8/29 03:25
 */
public class Problem029 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1, head);
        ListNode fast = head;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = pre;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除
        slow.next = slow.next.next;
        return pre.next;
    }
}
