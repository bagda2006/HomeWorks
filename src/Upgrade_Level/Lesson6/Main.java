package Upgrade_Level.Lesson6;

public class Main {
    public static void main(String[] args){
        MyQueue test = new MyQueue(10);
        test.enQueue(3);
        test.enQueue(4);
        test.enQueue(5);
        test.enQueue(6);
        System.out.println(test);
        test.pop();
        test.pop();
        System.out.println(test);
        System.out.println(test.peek());
    }
}
