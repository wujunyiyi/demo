package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Adam
 * @create: 2022/05/10 09:20
 */
public class LFUTest {

    @Test
    public void test() {
        LFUCache cache = new LFUCache(0);
        cache.put(1, 1);
        cache.get(1);
//        cache.put(2, 2);
//
//        cache.put(3, 3);
//        cache.get(2);
//        cache.get(3);
//        cache.put(4, 4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);
    }
}

// leetcode 460
class LFUCache {
    Map<Integer, Node<Integer, Integer>> keyHash;
    Map<Integer, DoubleLink<Integer, Integer>> freqHash;
    int minFreq = 0;
    int capacity;

    public LFUCache(int capacity) {
        keyHash = new HashMap<>(capacity);
        freqHash = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node<Integer, Integer> node = keyHash.get(key);
        if (node == null) {
            return -1;
        }

        removeFreqHash(node, node.freq);
        incrFreqHash(node, ++node.freq);
        if (!freqHash.containsKey(minFreq)) {
            minFreq++;
        }

        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        int freq;
        if (keyHash.containsKey(key)) {
            Node<Integer, Integer> node = keyHash.get(key);
            freq = node.freq;

            node.val = value;
            node.freq++;

            removeFreqHash(node, freq);
            incrFreqHash(node, freq + 1);
            if (!freqHash.containsKey(minFreq)) {
                minFreq++;
            }
        } else {
            if (capacity == keyHash.size()) {
                expire();
            }

            freq = 1;
            Node<Integer, Integer> node = new Node<>(key, value, freq);

            keyHash.put(key, node);
            incrFreqHash(node, freq);

            minFreq = freq;
        }
    }

    void expire() {
        DoubleLink<Integer, Integer> link = freqHash.get(minFreq);

        Node<Integer, Integer> rmNode = link.head.next;
        link.remove(rmNode);
        keyHash.remove(rmNode.key);

        if (link.isEmpty()) {
            freqHash.remove(minFreq);
        }
    }

    void removeFreqHash(Node<Integer, Integer> node, int freq) {
        DoubleLink<Integer, Integer> dl = freqHash.get(freq);
        if (dl == null) {
            return;
        }

        dl.remove(node);

        if (dl.isEmpty()) {
            freqHash.remove(freq);
        }
    }

    void incrFreqHash(Node<Integer, Integer> node, int freq) {
        DoubleLink<Integer, Integer> dl;
        if ((dl = freqHash.get(freq)) == null) {
            dl = new DoubleLink<>();
            freqHash.put(freq, dl);
        }

        dl.append(node);
    }

    class DoubleLink<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        int size = 0;

        public DoubleLink() {
            this.head = new Node<>(null, null, 0);
            this.tail = new Node<>(null, null, 0);

            head.next = tail;
            tail.pre = head;
        }

        public void append(Node<K, V> node) {
            Node<K, V> pre = tail.pre;

            node.pre = pre;
            node.next = tail;

            pre.next = node;
            tail.pre = node;

            size++;
        }

        public void remove(Node<K, V> node) {
            Node<K, V> pre = node.pre;
            Node<K, V> next = node.next;

            pre.next = next;
            next.pre = pre;

            size--;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    class Node<K, V> {
        K key;
        V val;
        int freq;

        Node<K, V> pre;
        Node<K, V> next;

        public Node(K key, V val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }
}


