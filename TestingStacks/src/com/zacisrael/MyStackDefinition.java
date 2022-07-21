package com.zacisrael;

interface MyStackDefinition {
    boolean isEmpty();
    boolean isFull();
    void push(String item);
    String pop();
    String top();
}