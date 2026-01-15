import java.util.*;

public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>(16);
        HashMap<Integer, String> map3 = new HashMap<>(16, 0.75f);
        HashMap<Integer, String> map4 = new HashMap<>(map1);

        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");

        System.out.println(map1.get(2));
        System.out.println(map1.containsKey(3));
        System.out.println(map1.containsValue("A"));
        System.out.println(map1.size());
        System.out.println(map1.isEmpty());

        map1.remove(1);
        map1.replace(2, "Z");

        System.out.println(map1.keySet());
        System.out.println(map1.values());
        System.out.println(map1.entrySet());

        map1.clear();
    }
}
