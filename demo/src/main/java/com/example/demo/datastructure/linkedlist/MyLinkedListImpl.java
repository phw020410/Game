package com.example.demo.datastructure.linkedlist;

import com.example.demo.datastructure.Node;

public class MyLinkedListImpl<E> implements MyLinkedList<E> {
    private Node node;
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedListImpl() {
        this.node = null;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public MyLinkedListImpl(E e) {
        this.node = new Node(e);
        this.head = node;
        this.tail = node;
        this.size = 1;
    }

    @Override
    public void add(E e) {
        if(isEmpty()) {
            this.node = new Node(e);
            this.head = node;
            this.tail = node;
            this.size = 1;
            return ;
        }

        Node newNode = new Node(e);
        this.tail.setNext(newNode);
        this.tail = this.tail.getNext();
        this.size ++;
    }

    @Override
    public void add(int idx, E e) {
        if(isEmpty()) {
            if(idx != 0) {
                System.out.println("You set index more than this list\'s index");
                return ;
            }
            this.node = new Node(e);
            this.head = node;
            this.tail = node;
            this.size = 1;
            return ;
        }

        Node preNode = this.head;
        for (int i = 0; i < idx; i++) {
            preNode = this.head;
            this.head = this.head.getNext();
        }
        Node newNode = new Node(e);
        newNode.setNext(this.head);
        if(preNode == this.head) {
            this.node = newNode;
        } else {
            preNode.setNext(newNode);
        }
        this.head = this.node;
        this.size ++;
    }

    @Override
    public void pop() {
        if(isEmpty() == true) {
            return ;
        }
    }

    @Override
    public void remove(int idx) {
    }
    
    @Override
    public boolean isEmpty() {
        return this.node == null ? true : false;
    }

    @Override
    public Node get() {
        return null;
    }

    @Override
    public Node get(int idx) {
        for (int i = 0; i < idx; i++) {
            this.head = this.head.getNext();
        }
        Node newNode = this.head;
        this.head = this.node;
        return newNode;
    }
    
    @Override
    public int getSize() {
        return this.size;
    };

    @Override
    public String toString() {
        try {
            String info = "Node : " + this.node + "\n" +
                        "Head : " + this.head + "\n";
            for (int i = 0; i < getSize(); i++) {
                info += i + " Node : " + get(i).getValue() + "\n";
            }
            info += "Tail : " + this.tail + "\n";
            
            return info;
        } catch(NullPointerException e) {
            return "All Node is Null";
        }
    }
}
