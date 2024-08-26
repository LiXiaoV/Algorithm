/**
 * 相交链表
 *
 * @Author: Xiaov
 * @Date: 2024/8/27 05:48
 */
public class Problem022 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 1, lenB = 1;
        while (null != nodeA.next) {
            nodeA = nodeA.next;
            lenA++;
        }
        while (null != nodeB.next) {
            nodeB = nodeB.next;
            lenB++;
        }
        if (nodeA != nodeB) return null;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        }
        while (headA != headB && headA.next != null && headB.next != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public ListNode getIntersectionNodeFunc2(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
