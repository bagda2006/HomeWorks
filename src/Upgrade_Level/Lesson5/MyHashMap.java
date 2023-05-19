package Upgrade_Level.Lesson5;

public class MyHashMap<K,V> {
    private int CAPACITY = 10;
    private Bucket[] buckets;
    private int size;
    public MyHashMap(){
        buckets = new Bucket[CAPACITY];
    }

    private int getHash(K key){
        //0xfffffff == Math.abs()
        return (key.hashCode()  & 0xfffffff)% CAPACITY;
    }

    private Pair getPair(K key){
        int hash = getHash(key);
        if(buckets[hash] == null) return null;
        for (int i = 0; i < buckets[hash].getPairs().size(); i++) {
            Pair<K,V> curPair = buckets[hash].getPairs().get(i);
            if(curPair.getKey().equals(key)){
                return curPair;
            }
        }
        return null;
    }

    public V get(K key){
        Pair curPair = getPair(key);
        if(curPair == null) return null;
       else return (V) getPair(key).getValue();
    }


    public boolean contains(K key) {
        if(getPair(key) != null)return true;
        else return false;
    }

    public void put(K key, V value){
        if (contains(key)){
            Pair curPair = getPair(key);
            curPair.setValue(value);
        }else {
            int hash = getHash(key);
            if(buckets[hash] == null){
                buckets[hash] = new Bucket();
            }
            buckets[hash].add(new Pair<>(key, value));
            size++;
        }
    }
    public void remove(K key){
        if (contains(key)){
            int hash = getHash(key);
            buckets[hash].remove(getPair(key));
            size--;
        }
    }
    public void print(){
        for (int i = 0; i < CAPACITY; i++) {
            if(buckets[i] != null){
                System.out.println("Bucket №" + i);
                for (int j = 0; j < buckets[i].getPairs().size(); j++) {
                    System.out.println(buckets[i].getPairs().get(j).getValue());
                }
            }
        }
    }

}
