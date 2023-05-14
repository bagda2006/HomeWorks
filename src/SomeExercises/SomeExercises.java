package SomeExercises;
import java.util.*;

public class SomeExercises {
    public interface Operationable{
        int square(int x, int y);

    }
    public static void main(String[] args){
        List<String> arr = new ArrayList<>();
        Collections.addAll(arr,"Hello","I'm","Bagdasar");
        long count =  arr.stream().filter(s -> s.length() >= 5).count();
        System.out.println(count);
        Operationable operation = (x,y)-> x * y;
        int res = operation.square(10,20);
        System.out.println(res);
    }
}
