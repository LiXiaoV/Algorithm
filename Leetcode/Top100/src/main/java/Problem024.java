import java.util.List;

/**
 * 回文链表
 *
 * @Author: Xiaov
 * @Date: 2024/8/27 06:25
 */
public class Problem024 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode newHead = null;
        ListNode pA = head;
        while (pA != null) {
            ListNode tmp = new ListNode(pA.val, newHead);
            newHead = tmp;
            pA = pA.next;
        }

        while (head != null && newHead != null) {
            if (head.val != newHead.val) return false;
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    public boolean isPalindromeFunc2(ListNode head) {
        if (head == null) return false;

        ListNode halfOfEnd = halfOfEnd(head);
        ListNode secondHalfStart = reverseListNode(halfOfEnd.next);
        ListNode pA = head;
        ListNode pB = secondHalfStart;
        boolean res = true;
        while (res && pA != null && pB != null) {
            if (pA.val != pB.val) res = false;
            pA = pA.next;
            pB = pB.next;
        }

        halfOfEnd.next = reverseListNode(secondHalfStart);
        return res;
    }

    public ListNode reverseListNode(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }
    public ListNode halfOfEnd(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
