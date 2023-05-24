package Upgrade_Level.Lesson6;

import java.util.LinkedList;

public class ListQueue{
    private LinkedList<Integer> queue;

    public void enQueue(int element){
        queue.add(element);
    }

    public int peek() {
        return queue.getFirst();
    }

    public int pop(){
        return queue.removeFirst();
    }

    public int front(){
        return queue.getFirst();
    }

    public int rear(){
        return queue.getLast();
    }

    public int getSize(){
        return queue.size();
    }
}
