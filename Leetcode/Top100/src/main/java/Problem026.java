import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 *
 * @Author: Xiaov
 * @Date: 2024/8/28 04:24
 */
public class Problem026 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode pA = head;
        while (pA != null) {
            if (!nodeSet.add(pA)) {
                return pA;
            }
            pA = pA.next;
        }
        return null;
    }

    // 快慢指针，a = (n-1)(b+c) + c ,此时slow正好在b那儿，slow再走a的距离就是n圈，与从头开始走相遇
    public ListNode detectCycleFunc2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pA = head;
        while (pA != slow) {
            pA = pA.next;
            slow = slow.next;
        }

        return slow;
    }
}
