import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 排序链表
 *
 * @Author: Xiaov
 * @Date: 2024/9/1 21:20
 */
public class Problem033 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // arrayList排序
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode pA = head;
        while (pA != null) {
            list.add(pA);
            pA = pA.next;
        }
        ListNode[] listNodes = new ListNode[list.size()];
        list.toArray(listNodes);
        Arrays.sort(listNodes, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode res = new ListNode(-1);
        ListNode cursor = res;
        for (ListNode listNode : listNodes) {
            cursor.next = listNode;
            cursor = cursor.next;
        }
        cursor.next = null;
        return res.next;
    }

    // 递归，归并
    public ListNode sortListFunc2(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return null;
        // 拆分，取头去尾
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1, list2);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode pA = list1, pB = list2;
        ListNode cursor = dummyHead;
        while (pA != null && pB != null) {
            if (pA.val < pB.val) {
                cursor.next = pA;
                pA = pA.next;
            } else {
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

    // 迭代，归并
    public ListNode sortListFunc3(ListNode head) {
        if (head == null) return null;
        ListNode cursor = head;
        int length = 0;
        while (cursor != null) {
            length++;
            cursor = cursor.next;
        }

        ListNode dummyHead = new ListNode(-1, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead;
            ListNode cur = dummyHead.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;

                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                ListNode sorted = merge(head1, head2);
                prev.next = sorted;
                while (prev.next != null) {
                    prev = prev.next;
                }
                cur = next;
            }
        }
        return dummyHead.next;
    }
}
