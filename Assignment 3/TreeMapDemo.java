import java.util.*;

public class TreeMapDemo {

    public static void main(String[] args) {

        TreeMap<Integer, String> tm1 = new TreeMap<>();
        TreeMap<Integer, String> tm2 = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer, String> tm3 = new TreeMap<>(tm1);
        TreeMap<Integer, String> tm4 = new TreeMap<>(Map.of(1,"A",2,"B"));

        tm1.put(3, "C");
        tm1.put(1, "A");
        tm1.put(2, "B");

        System.out.println(tm1.firstKey());
        System.out.println(tm1.lastKey());
        System.out.println(tm1.higherKey(1));
        System.out.println(tm1.lowerKey(3));
        System.out.println(tm1.ceilingKey(2));
        System.out.println(tm1.floorKey(2));

        System.out.println(tm1.headMap(3));
        System.out.println(tm1.tailMap(2));
        System.out.println(tm1.subMap(1, 3));

        tm1.remove(2);
        System.out.println(tm1.entrySet());

        tm1.clear();
    }
}
