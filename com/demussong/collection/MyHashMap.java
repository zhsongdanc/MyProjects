package com.demussong.collection;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/20 13:18
 */
public class MyHashMap<K,V> {
    private Node<K,V>[] nodes;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 16;



    static class Node<K, V>{
        K k;
        V v;
        int hash;
        Node<K, V> next;

        public Node() {

        }

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public MyHashMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.nodes = new Node[DEFAULT_CAPACITY];
    }



    public V get(K k) {
        return null;
    }

    public void put(K k, V v) {
        Node<K,V> node = new Node<>(k,v);
        int index = hash(node) & capacity;

        Node<K,V> first = nodes[index];
        if (first == null) {
            nodes[index] = node;
            return;
        }
        if (hash(first) == hash(node) && (first.k == node.k || (node.k != null && node.k.equals(first.k)))) {
            Node<K, V> originNext = first.next;
            first.next = null;
            nodes[index] = node;
            node.next = originNext;
            return;
        }

        Node<K, V> pre = first, cur = first.next;
        while (cur != null) {


            if (hash(cur) == hash(node) && (cur.k == node.k || (node.k != null && node.k.equals(cur.k)))) {
                Node<K, V> originNext = cur.next;
                cur.next = null;
                pre.next = node;
                node.next = originNext;
                return;
            }


            pre = cur;
            cur = cur.next;
        }

        pre.next = node;
        size++;
        ensureCapacity(size);

    }

    public int hash(Node<K,V> node) {
        if (node.k == null) {
            return 0;
        }
        int h = node.k.hashCode();
        return h^(h>>>8)^(h>>>16)^(h>>>24);
    }

    public void ensureCapacity(int size) {

    }

    public void resize() {

    }
}
