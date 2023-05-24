package Upgrade_Level.Lesson6;

import java.util.Arrays;

public class MyQueue<V> {
    private int capacity;
    int queue[];
    int front,rear;

    public MyQueue(int capacity){
        this.capacity = capacity;
        queue = new int[this.capacity];
        front = -1;
        rear = -1;
    }

    private void Swap(int first,int second){
        int a = queue[first];
        queue[first] = queue[second];
        queue[second] = a;
    }
    public void enQueue(int element){
        if(rear == capacity - 1){
            System.out.println("Queue is full");
        }else {
            if(front == -1) {
                front++;
            }
            rear++;
            queue[rear] = element;
        }
        for (int i = front; i < rear; i++) {
            for(int j = rear; j > front; j--){
                if (queue[j-1] > queue[j]){
                    Swap(j-1,j);
                }
            }
        }
    }

    public int peek(){
        if (front == -1){
            System.out.println("Queue is empty");
            System.exit(-1);
        }
        return queue[front];
    }

    public int pop(){
        int temp = 0;
        if (front == -1){
            System.out.println("Queue is empty!");
            System.exit(-1);
        }else if (front == rear){
            temp = queue[front];
            front = rear = -1;
        }else{
            temp = queue[front];
            front++;
        }
        return temp;
    }

    public int getFront(){
        return queue[front];
    }

    public int getRear(){
        return queue[rear];
    }

    public String toString(){
        String str = "[";
        for (int i = front; i < rear ; i++) {
            str = str + queue[i] + ", ";
        }
        str = str + queue[rear] + "] ";
        return str;
    }
}
