package Upgrade_Level.Lesson5;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MyHashMap<K,V> {
    private int CAPACITY = 10;
    private MyMapBucket[] bucket;
    private int size;

    public MyHashMap(){
        this.bucket = new MyMapBucket[CAPACITY];
    }

    public int size(){
        return size;
    }

    private int getHash(K key){
        return key.hashCode() & (CAPACITY - 1);
    }

    private MyKeyValueEntry getEntry(K key){
        int hash = getHash(key);
        for(int i = 0;i < bucket[hash].getEntries().size();i++){
            MyKeyValueEntry myKeyValueEntry = bucket[hash].getEntries().get(i);
            if (myKeyValueEntry.getKey().equals(key)){
                return myKeyValueEntry;
            }
        }
        return null;
    }

    public boolean containsKey(K key){
        int hash = getHash(key);
        return !(Objects.isNull(bucket[hash]) || Objects.isNull((getEntry(key))));
    }

    public V put(K key, V value){
        if(containsKey(key)){
            MyKeyValueEntry entry = getEntry(key);
            V temp = (V) entry.getValue();
            entry.setValue(value);
            return temp;
        }else{
            int hash = getHash(key);
            if(bucket[hash] == null){
                bucket[hash] = new MyMapBucket();
            }
            bucket[hash].addEntry(new MyKeyValueEntry<>(key,value));
            size++;
        }
        return null;
    }

    public V get(K key){
        return containsKey(key) ? (V) getEntry(key).getValue() : null;
    }

    public V remove(K key){
        if(containsKey(key)){
            V temp = get(key);
            int hash = getHash(key);
            bucket[hash].removeEntry(getEntry(key));
            size--;
            return temp;
        }
        return null;
    }


    public static void main(String[] args) {
        MyHashMap<Integer,String> myHashMap = new MyHashMap<>();
        myHashMap.put(1,"Hello");//Добавление элемента
        myHashMap.put(2,"Yup");
        myHashMap.put(3,"Bye");
        myHashMap.put(4,"Lol");
        myHashMap.put(5,"Hi");
        System.out.println(myHashMap.size());//размер hashmap
        System.out.println(myHashMap.get(4));//вытаскиваем элемент с ключом 4
        System.out.println(myHashMap.remove(2));//удаляем элемент с ключем 2
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.containsKey(1));//проверяем есть ли в hshmap эл-т с ключем 1
    }
}
