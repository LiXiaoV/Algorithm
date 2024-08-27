/**
 * 合并两个有序链表
 *
 * @Author: Xiaov
 * @Date: 2024/8/28 04:46
 */
public class Problem027 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newListNode = new ListNode();
        newListNode.next = null;
        ListNode tail = newListNode;
        ListNode pA = list1, pB = list2;
        while (pA != null && pB != null) {
            if (pA.val < pB.val) {
                tail.next = pA;
                tail = pA;
                pA = pA.next;
            } else {
                tail.next = pB;
                tail = pB;
                pB = pB.next;
            }
        }
        tail.next = pA == null ? pB : pA;
        return newListNode.next;
    }
}
