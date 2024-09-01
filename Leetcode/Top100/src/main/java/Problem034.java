import java.util.List;

/**
 * 合并 K 个升序链表
 *
 * @Author: Xiaov
 * @Date: 2024/9/2 02:37
 */
public class Problem034 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    public static ListNode mergeLists(ListNode[] lists, int start, int end) {
        if(start > end) return null;
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) >> 1;
        ListNode list1 = mergeLists(lists, start, mid);
        ListNode list2 = mergeLists(lists, mid + 1, end);
        return merge(list1, list2);
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummyHead = new ListNode(-1);
        ListNode pA = list1;
        ListNode pB = list2;
        ListNode cursor = dummyHead;
        while (pA != null && pB != null) {
            if (pA.val < pB.val) {
                cursor.next = pA;
                pA = pA.next;
            }else {
                cursor.next = pB;
                pB = pB.next;
            }
            cursor = cursor.next;
        }
        if (pA != null) {
            cursor.next = pA;
        }
        if (pB != null) {
            cursor.next = pB;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(1, node2);

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3, node4);
        ListNode node6 = new ListNode(1, node5);

        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(2, node7);

        ListNode[] lists = new ListNode[3];
        lists[0] = node3;
        lists[1] = node6;
        lists[2] = node8;
        ListNode res = mergeKLists(lists);
        System.out.println("res = " + "res");

    }
}
