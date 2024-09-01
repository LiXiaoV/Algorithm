/**
 * 随机链表的复制
 *
 * @Author: Xiaov
 * @Date: 2024/9/1 20:23
 */
public class Problem032 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node pA = head;
        while (pA != null) {
            Node copyNode = new Node(pA.val);
            copyNode.next = pA.next;
            pA.next = copyNode;
            pA = pA.next.next;
        }

        pA = head;
        while (pA != null) {
            Node copyNode = pA.next;
            if (pA.random != null) {
                copyNode.random = pA.random.next;
            }
            pA = pA.next.next;
        }

        Node res = new Node(-1);
        Node cursor = res;
        pA = head;
        while (pA != null) {
            Node copyNode = pA.next;
            cursor.next = copyNode;
            cursor = cursor.next;
            pA.next = pA.next.next;
            pA = pA.next;
        }
        return res.next;
    }
}
