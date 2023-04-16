package com.example.demo.datastructure.linkedlist;

import com.example.demo.datastructure.Node;

public interface MyLinkedList<E> {
    void add(E e);
    void add(int idx, E e);
    void pop();
    void remove(int idx);
    boolean isEmpty();
    Node get();
    Node get(int idx);
    int getSize();
}
