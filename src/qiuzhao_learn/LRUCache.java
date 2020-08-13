package qiuzhao_learn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alery
 * @Description
 * @create 2020-08-12 21:49
 */
public class LRUCache {

    private Map<Integer, Node> cache;
    private int capacity;
    private int size;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node t = new Node(key, value);
            cache.put(key, t);
            addHeadNode(t);
            size++;
            if (size > capacity) {
                Node del = removeTail();
                cache.remove(del.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addHeadNode(node);
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addHeadNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.get(3);
        lruCache.put(5, 5);
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int _key, int _value) {
            key = _key;
            value = _value;
        }

        public Node() {

        }
    }

}
