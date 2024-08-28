/**
 * 两数相加
 *
 * @Author: Xiaov
 * @Date: 2024/8/29 03:04
 */
public class Problem028 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int curVal = 0;
        ListNode pA = l1;
        ListNode pB = l2;

        ListNode res = new ListNode(-1);
        ListNode cursor = res;

        while (pA != null || pB != null) {
            if (pA != null) {
                curVal += pA.val;
                pA = pA.next;
            }
            if (pB != null) {
                curVal += pB.val;
                pB = pB.next;
            }
            ListNode node = new ListNode(curVal % 10);
            cursor.next = node;
            cursor = node;
            curVal /= 10;
        }

        if (curVal > 0) {
            ListNode node = new ListNode(curVal);
            cursor.next = node;
        }
        return res.next;
    }
}
