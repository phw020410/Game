package com.example.demo.datastructure;

public class Node {
    private Object value;
    private Node next;

    public Node() {
        this.value = null;
        this.next = null;
    }
    
    public Node(Object o) {
        this.value = o;
        this.next = null;
    }

    public void setValue(Object o) {
        this.value = o;
    } 

    public Object getValue() {
        return this.value;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public Node getNext() {
        return this.next;
    }
}
