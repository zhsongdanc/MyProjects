package com.demussong.datastructure;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/22 17:11
 */
import java.util.Random;

public class SkipList<T> {
    private SkipListNode<T> head, tail;
    private int nodes;
    private int listLevel;
    private Random random;
    private static final double PROBABILITY = 0.5;

    public SkipList() {
        random = new Random();
        clear();
    }

    public void clear() {
        head = new SkipListNode<T>(SkipListNode.HEAD_KEY, null);
        tail = new SkipListNode<T>(SkipListNode.TAIL_KEY, null);
        horizontalLink(head, tail);
        listLevel = 0;
        nodes = 0;
    }

    public boolean isEmpty() {
        return nodes == 0;
    }

    public int size() {
        return nodes;
    }

    private void horizontalLink(SkipListNode<T> node1, SkipListNode<T> node2) {
        node1.right = node2;
        node2.left = node1;
    }

    private void verticalLink(SkipListNode<T> node1, SkipListNode<T> node2) {
        node1.down = node2;
        node2.up = node1;
    }

    public void put(int key, T value) {
        SkipListNode<T> p = findNode(key);
        if (p.key == key) {
            p.value = value;
            return;
        }
        SkipListNode<T> q = new SkipListNode<T>(key, value);
        backLink(p, q);
        int currentLevel = 0;
        while (random.nextDouble() < PROBABILITY) {
            if (currentLevel >= listLevel) {
                listLevel++;
                SkipListNode<T> p1 = new SkipListNode<T>(SkipListNode.HEAD_KEY, null);
                SkipListNode<T> p2 = new SkipListNode<T>(SkipListNode.TAIL_KEY, null);
                horizontalLink(p1, p2);
                verticalLink(p1, head);
                verticalLink(p2, tail);
                head = p1;
                tail = p2;
            }
            while (p.up == null) {
                p = p.left;
            }
            p = p.up;
            SkipListNode<T> e = new SkipListNode<T>(key, null);
            backLink(p, e);
            verticalLink(e, q);
            q = e;
            currentLevel++;
        }
        nodes++;
    }

    // 后面加了一个SkipListNode
    private void backLink(SkipListNode<T> node1, SkipListNode<T> node2) {
        node2.left = node1;
        node2.right = node1.right;
        node1.right.left = node2;
        node1.right = node2;
    }

    public T get(int key) {
        SkipListNode<T> node = findNode(key);
        return (node.key == key) ? node.value : null;
    }

    private SkipListNode<T> findNode(int key) {
        SkipListNode<T> p = head;
        while (true) {
            while (p.right.key != SkipListNode.TAIL_KEY && p.right.key <= key) {
                p = p.right;
            }
            if (p.down != null) {
                p = p.down;
            } else {
                break;
            }
        }
        return p;
    }

    public boolean containsKey(int key) {
        SkipListNode<T> node = findNode(key);
        return (node.key == key);
    }

    public void remove(int key) {
        SkipListNode<T> p = findNode(key);
        if (p.key != key) {
            return;
        }
        while (p != null) {
            p.left.right = p.right;
            p.right.left = p.left;
            p = p.up;
        }
        nodes--;
    }

    class SkipListNode<T> {
        public int key;
        public T value;
        public SkipListNode<T> up, down, left, right;
        public static final int HEAD_KEY = Integer.MIN_VALUE;
        public static final int TAIL_KEY = Integer.MAX_VALUE;

        public SkipListNode(int k, T v) {
            key = k;
            value = v;
        }
    }
}
