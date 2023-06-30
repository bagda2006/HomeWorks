package Upgrade_Level.Lesson5;

//Bucket = MyBucketMap
//Pair = entry
//Pairs = MyEntryKeyValue

import java.util.HashMap;

public class MyHashSet<E> {
    MyHashMap<E,Object> map = new MyHashMap<>();
    private final static Object PRESENT = new Object();

    public boolean add(E e){
        return  map.put(e,PRESENT) == null;
    }

    public boolean remove(E e){
        return map.remove(e) == PRESENT;
    }

    public boolean contains(E e){
        return map.containsKey(e);
    }

    public int size(){
        return map.size();
    }


    public static void main(String[] args) {
        MyHashSet<Integer> myHashSet = new MyHashSet<>();
        myHashSet.add(100);
        myHashSet.add(213);//добавление элемента
        myHashSet.add(412);
        myHashSet.add(4231);
        System.out.println(myHashSet.contains(100));//ищем элемент
        myHashSet.remove(100);//удаляем элемент
        System.out.println(myHashSet.size());//размер hashset

    }
}
