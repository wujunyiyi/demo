package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Adam
 * @create: 2022/05/05 14:56
 */
public class LRUTest {
    @Test
    public void test1() {
        LRUCache cache = new LRUCache(1);

        cache.put(1, 1);
        cache.get(1);
    }
}

/**
 * hash+双向链表实现
 * leetcode 146
 */
class LRUCache {
    int capacity;
    Map<Integer, Node<Integer, Integer>> hash;
    Node<Integer, Integer> head;
    Node<Integer, Integer> tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.hash = new HashMap<>(capacity);

        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node<Integer, Integer> node = hash.get(key);
        if (node == null) {
            return -1;
        }

        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (hash.containsKey(key)) {
            Node<Integer, Integer> node = hash.get(key);
            node.val = value;

            moveToTail(node);
        } else {
            if (hash.size() == capacity) {
                Node<Integer, Integer> node = head.next;
                remove(node);
                hash.remove(node.key);
            }

            Node<Integer, Integer> node = new Node<>(key, value);
            append(node);
            hash.put(key, node);
        }
    }

    private void append(Node<Integer, Integer> node) {
        Node<Integer, Integer> preNode = tail.pre;
        node.pre = preNode;
        node.next = tail;
        preNode.next = node;

        tail.pre = node;
    }

    private void remove(Node<Integer, Integer> node) {
        Node<Integer, Integer> preNode = node.pre;
        Node<Integer, Integer> nextNode = node.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    private void moveToTail(Node<Integer, Integer> node) {
        remove(node);
        append(node);
    }

    class Node<K, V> {
        K key;
        V val;
        Node<K, V> pre;
        Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}

class LRULinkHashMapCache {
    private LinkedHashMap<Integer, Integer> map;

    public LRULinkHashMapCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.get(key) == null ? -1 : map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
