package Upgrade_Level.Lesson2_3;

public class Main {
    public static void main(String[] args) {
        MySingleLinkedList<Integer> myList = new MySingleLinkedList<>();
        myList.add(100);
        myList.add(101);
        myList.add(78);
        myList.add(90);
        myList.add(76);
        myList.add(57);
        myList.add(7);
        myList.add(13);
        myList.printList();
        myList.add(151,3);
        myList.printList();
    }
}
