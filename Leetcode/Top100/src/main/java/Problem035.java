import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 缓存
 *
 * @Author: Xiaov
 * @Date: 2024/9/2 03:12
 */
public class Problem035 extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public Problem035(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > capacity;
    }

    public class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public class LRUCache{
        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                DLinkedNode node = cache.get(key);
                moveToHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)){
                DLinkedNode node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                DLinkedNode newNode = new DLinkedNode(key, value);
                if (cache.size() == capacity) {
                    DLinkedNode tailNode = tail.prev;
                    cache.remove(tailNode.key);
                    removeNode(tailNode);
                    this.size--;
                }
                cache.put(key, newNode);
                addToHead(newNode);
                this.size++;
            }
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeNode(DLinkedNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void addToHead(DLinkedNode node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

    }
}
