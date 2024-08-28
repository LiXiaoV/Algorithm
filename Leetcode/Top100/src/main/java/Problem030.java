/**
 * 两两交换链表中的节点
 *
 * @Author: Xiaov
 * @Date: 2024/8/29 03:41
 */
public class Problem030 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1, head);
        ListNode cursor = pre;
        while (cursor.next != null && cursor.next.next != null) {
            // 先切掉首个
            ListNode first = cursor.next;
            // 接到后面
            cursor.next = cursor.next.next;
            first.next = cursor.next.next;
            cursor.next.next = first;

            cursor = cursor.next.next;
        }
        return pre.next;
    }


}
