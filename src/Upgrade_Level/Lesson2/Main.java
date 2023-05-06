package Upgrade_Level.Lesson2;

public class Main {
    public static void main(String[] args) {
        ClassWork2.MyArrayList<String> myArrayList = new ClassWork2.MyArrayList();
        myArrayList.add("Hello");
        myArrayList.remove("Hello");
        myArrayList.add("GoodBye");
        String str = myArrayList.get(0).toString();
        System.out.println(str);
    }
}
