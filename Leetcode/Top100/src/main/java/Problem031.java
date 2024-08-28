/**
 * K 个一组翻转链表
 *
 * @Author: Xiaov
 * @Date: 2024/8/29 04:03
 */
public class Problem031 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(-1, head);
        ListNode cursor = pre;
        ListNode pA = head;

        int count = 1;
        while (pA != null) {
            ListNode pANext = pA.next;
            if (count % k == 0) {
                ListNode kFirst = cursor.next;
                ListNode pB = kFirst;
                while (pB != pANext) {
                    // 记录下一个
                    ListNode next = pB.next;

                    // 头插
                    pB.next = cursor.next;
                    cursor.next = pB;

                    pB = next;
                }
                cursor = kFirst;
                cursor.next = pANext;
            }

            pA = pANext;
            count++;
        }
        return pre.next;
    }
}
