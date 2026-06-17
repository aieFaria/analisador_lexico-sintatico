package com.faria.tree;

import java.util.Objects;

public class Node<T extends Comparable<T>> {

    private T value;

    public Node(){

    }

    public Node(T valor){
        this.value = valor;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {

        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {

        Node<T> no = new Node<>();

        if(obj instanceof Node) {
            no = (Node<T>) obj;
        } else {
            return false;
        }
        
        return Objects.equals(this.getValue(), no.getValue());

    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString(){
        return this.getValue().toString();
    }

}
