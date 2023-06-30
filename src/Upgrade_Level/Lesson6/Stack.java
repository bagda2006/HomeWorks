package Upgrade_Level.Lesson6;

import java.util.LinkedList;

public class Stack {
    private int size;
    private int items[];
    private int top;

    public Stack(int size) {
        this.size = size;
        items = new int[this.size];
        top = -1;
    }

    private boolean isNull() {
        return top == size - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void push(int element) {
        if (isNull()) {
            System.out.println("Стек заполнен");
        } else {
            System.out.println("Добавлен элемент " + element);
            items[++top] = element;
        }
    }
    public int pop(){
        int element;
        if (isEmpty()){
            System.out.println("Стек пустой");
            return -1;
        }
        element = items[top--];
        System.out.println("Удален элемент " + element);
        return element;
    }

    public int size(){
        return top + 1;
    }


}
