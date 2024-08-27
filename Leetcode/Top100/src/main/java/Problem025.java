import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 环形链表
 *
 * @Author: Xiaov
 * @Date: 2024/8/28 04:09
 */
public class Problem025 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode pA = head;
        while (pA != null) {
            if (!nodeSet.add(pA)) {
                return true;
            }
            pA = pA.next;
        }
        return false;
    }

    // 快慢指针
    public boolean hasCycleFunc2(ListNode head) {
        if (null == head) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
