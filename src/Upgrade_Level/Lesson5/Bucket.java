package Upgrade_Level.Lesson5;

import java.util.LinkedList;
import java.util.List;

public class Bucket {
    List<Pair> pairs;

    public Bucket(){
        pairs = new LinkedList<>();
    }

    public List<Pair> getPairs(){
        return pairs;
    }

    public void add(Pair pair){
        pairs.add(pair);
    }

    public void remove(Pair pair){
        pairs.remove(pair);
    }
}
